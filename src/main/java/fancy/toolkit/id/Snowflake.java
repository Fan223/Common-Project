package fancy.toolkit.id;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 雪花 ID 类.
 *
 * @author Fan
 * @since 2025/2/17 17:01
 */
public record Snowflake(long dataCenterId, long workerId) {

    /**
     * 数据中心 ID 占用的位数, 为 5 位.
     */
    private static final long DATA_CENTER_ID_BITS = 5;

    /**
     * 数据中心 ID 占用 5 位, 最大值为 31.
     * <ul>
     *     <li> -1 << 5 = -32, 原码为: 1111111111111111111111111111111111111111111111111111111111100000 </li>
     *     <li> 取反后为: 0000000000000000000000000000000000000000000000000000000000011111 </li>
     * </ul>
     */
    private static final long MAX_DATA_CENTER_ID = ~(-1L << DATA_CENTER_ID_BITS);

    /**
     * 机器 ID 占用的位数, 为 5 位.
     */
    private static final long WORKER_ID_BITS = 5;

    /**
     * 机器 ID 占用 5 位, 最大值为 31.
     */
    private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);

    /**
     * 序列号占用的位数, 为 12 位.
     */
    private static final long SEQUENCE_BITS = 12L;

    /**
     * 序列掩码(最低 12 位为 1, 高位都为 0), 最大值为 4095. 主要用于与自增后的序列号进行位与, 如果值为 0, 则代表自增后的序列号超过了 4095.
     */
    private static final long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS);

    /**
     * {@code workerId} 需要左移的位数, 为 12 位, 也就是右边为 序列号.
     */
    private static final long WORKER_ID_SHIFT = SEQUENCE_BITS;

    /**
     * {@code dataCenterId} 需要左移的位数, 为 12+5 位, 也就是右边为 机器ID+序列号.
     */
    private static final long DATA_CENTER_ID_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;

    /**
     * {@code timestamp} 需要左移的位数, 为 12+5+5 位, 也就是右边为 数据中心ID+机器ID+序列号.
     */
    private static final long TIMESTAMP_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + DATA_CENTER_ID_BITS;

    /**
     * 初始时间.
     */
    private static final long INITIAL_EPOCH = 1739842821425L;

    /**
     * 记录最后使用的毫秒时间戳, 主要用于判断是否同一毫秒, 以及用于服务器时钟回拨判断.
     */
    private static final AtomicLong lastTimestamp = new AtomicLong(-1L);

    /**
     * 同一毫秒内的最新序列号, 最大值为(2^12 - 1 = 4095).
     */
    private static final AtomicLong sequence = new AtomicLong(0L);

    /**
     * 时钟错误信息.
     */
    private static final String CLOCK_ERROR_MESSAGE = "可能出现服务器时钟回拨问题, 请检查服务器时间. 当前服务器时间戳: %d, 上一次使用时间戳: %d";

    public Snowflake() {
        this(IdUtils.getWorkerId(IdUtils.getDataCenterId(MAX_DATA_CENTER_ID), MAX_WORKER_ID));
    }

    public Snowflake(long workerId) {
        this(IdUtils.getDataCenterId(MAX_DATA_CENTER_ID), workerId);
    }

    /**
     * 用雪花算法生成 {@code nextId}, 这里使用 {@link AtomicLong} 原子类代替锁来保证线程安全, .
     *
     * @return {@code long}
     * @author Fan
     * @since 2025/2/18 9:42
     */
    public long nextId() {
        // 如果当前时间戳小于上次使用的时间戳, 则表明操作系统时间已经倒退
        long currentTimestamp = System.currentTimeMillis();
        if (currentTimestamp < lastTimestamp.get()) {
            throw new IllegalStateException(String.format(CLOCK_ERROR_MESSAGE, currentTimestamp, lastTimestamp.get()));
        }

        // 如果当前时间戳等于上次使用的时间戳, 则表示同一毫秒内, 序列号自增
        if (currentTimestamp == lastTimestamp.get()) {
            // 序列号每次加 1, 然后和序列掩码进行位于, 使用原子操作保证线程安全
            final long seq = (sequence.getAndIncrement() + 1) & SEQUENCE_MASK;
            // 为 0 则表示序列号大于 4095, 当前毫秒使用的序列号已达到最大个数, 使用新的时间戳
            if (0 == seq) {
                currentTimestamp = tilNextMillis(lastTimestamp.get());
            }
            sequence.set(seq);
        } else {
            // 不在同一毫秒内, 则序列号重新从 0 开始
            sequence.set(0L);
        }

        // 记录最后一次使用的毫秒时间戳
        lastTimestamp.set(currentTimestamp);
        // 核心算法, 将不同部分的数值移动到指定的位置, 然后进行位或操作生成唯一ID
        return ((currentTimestamp - INITIAL_EPOCH) << TIMESTAMP_SHIFT)
                | (dataCenterId << DATA_CENTER_ID_SHIFT)
                | (workerId << WORKER_ID_SHIFT)
                | sequence.get();
    }

    /**
     * 等待下一毫秒时间戳.
     *
     * @param timestamp 时间戳
     * @return {@code long}
     * @author Fan
     * @since 2025/2/18 9:22
     */
    private long tilNextMillis(long timestamp) {
        // 循环, 直到操作系统时间戳更改
        long currentTimestamp;
        do {
            currentTimestamp = System.currentTimeMillis();
        } while (currentTimestamp == timestamp);

        // 如果当前时间戳小于上次使用的时间戳, 则表明操作系统时间已经倒退
        if (currentTimestamp < timestamp) {
            throw new IllegalStateException(String.format(CLOCK_ERROR_MESSAGE, currentTimestamp, timestamp));
        }
        return currentTimestamp;
    }
}
