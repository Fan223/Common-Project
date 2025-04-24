package fancy.toolkit.id;

import fancy.toolkit.util.ProcessUtils;
import fancy.toolkit.net.NetUtils;
import fancy.toolkit.constant.HexConstants;

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
     * 获取雪花 ID.
     *
     * @return {@code long}
     * @author Fan
     * @since 2025/2/19 9:20
     */
    public static long getSnowflakeId() {
        return SNOWFLAKE.nextId();
    }

    /**
     * 获取数据中心 ID.
     *
     * @param maxDataCenterId 最大数据中心 ID
     * @return {@code long}
     * @author Fan
     * @since 2025/2/19 8:36
     */
    public static long getDataCenterId(long maxDataCenterId) {
        long id = 1L;
        byte[] mac = NetUtils.getLocalHardwareAddress();
        if (null != mac) {
            id = ((HexConstants.FF & (long) mac[mac.length - 2]) | (HexConstants.FF00 & (((long) mac[mac.length - 1]) << 8))) >> 6;
            id = id % (maxDataCenterId + 1);
        }
        return id;
    }

    /**
     * 获取机器 ID.
     *
     * @param dataCenterId 数据中心 ID
     * @param maxWorkerId  最大机器 ID
     * @return {@code long}
     * @author Fan
     * @since 2025/2/19 8:38
     */
    public static long getWorkerId(long dataCenterId, long maxWorkerId) {
        String workerId = String.valueOf(dataCenterId) + ProcessUtils.getCurrentPid();
        // DataCenterId + Pid 的 HashCode 获取 16 个低位
        return (workerId.hashCode() & HexConstants.FFFF) % (maxWorkerId + 1);
    }
}
