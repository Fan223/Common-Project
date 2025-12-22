package fan.fancy.toolkit.system;

import lombok.experimental.UtilityClass;

/**
 * {@link Runtime} 工具类.
 *
 * @author Fan
 */
@UtilityClass
public class RuntimeUtils {

    /**
     * 获取可用的处理器数量, 一般为 CPU 核心数.
     *
     * @return {@code int}
     */
    public static int getAvailableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }
}
