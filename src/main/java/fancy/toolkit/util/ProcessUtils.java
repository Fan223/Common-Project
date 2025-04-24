package fancy.toolkit.util;

/**
 * {@link Process} 工具类.
 *
 * @author Fan
 * @since 2025/2/17 16:45
 */
public class ProcessUtils {

    private ProcessUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * 获取当前进程 ID.
     *
     * @return {@code long}
     * @author Fan
     * @since 2025/2/17 16:51
     */
    public static long getCurrentPid() {
        return ProcessHandle.current().pid();
    }
}
