package fancy.toolkit.util;

import fancy.toolkit.Snowflake;
import fancy.toolkit.net.NetUtils;
import fancy.toolkit.pool.HexPool;

/**
 * ID 工具类.
 *
 * @author Fan
 * @since 2025/2/18 16:23
 */
public class IdUtils {

    private static final Snowflake SNOWFLAKE = new Snowflake();

    private IdUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * 获取数据中心ID.
     *
     * @param maxDataCenterId 最大数据中心ID
     * @return {@code long}
     * @author Fan
     * @since 2025/2/19 8:36
     */
    public static long getDataCenterId(long maxDataCenterId) {
        long id = 1L;
        byte[] mac = NetUtils.getLocalHardwareAddress();
        if (null != mac) {
            id = ((HexPool.FF & (long) mac[mac.length - 2]) | (HexPool.FF00 & (((long) mac[mac.length - 1]) << 8))) >> 6;
            id = id % (maxDataCenterId + 1);
        }
        return id;
    }

    /**
     * 获取机器ID.
     *
     * @param dataCenterId 数据中心ID
     * @param maxWorkerId  最大机器ID
     * @return {@code long}
     * @author Fan
     * @since 2025/2/19 8:38
     */
    public static long getWorkerId(long dataCenterId, long maxWorkerId) {
        String workerId = String.valueOf(dataCenterId) + ProcessUtils.getCurrentPid();
        // DataCenterId + Pid 的 HashCode 获取 16 个低位
        return (workerId.hashCode() & HexPool.FFFF) % (maxWorkerId + 1);
    }

    /**
     * 获取雪花ID.
     *
     * @return {@code long}
     * @author Fan
     * @since 2025/2/19 9:20
     */
    public static long getSnowflakeId() {
        return SNOWFLAKE.nextId();
    }
}
