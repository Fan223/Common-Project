package fancy.toolkit.util;

/**
 * {@link Runtime} 工具类.
 *
 * @author Fan
 * @since 2025/2/19 9:35
 */
public class RuntimeUtils {

    private RuntimeUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * 获取可用的处理器数量, 一般为 CPU 核心数.
     *
     * @return {@code int}
     * @author Fan
     * @since 2025/2/19 9:36
     */
    public static int getAvailableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }
}
