package fancy.toolkit.text;

/**
 * 字符工具类.
 *
 * @author Fan
 * @since 2025/2/17 16:41
 */
public class CharUtils {

    private CharUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * 判断字符是否为空白字符.
     *
     * @param ch 字符
     * @return {@code boolean}
     * @author Fan
     * @since 2025/2/19 9:27
     */
    public static boolean isBlank(char ch) {
        return Character.isWhitespace(ch);
    }

    /**
     * 判断字符是否不为空白字符.
     *
     * @param ch 字符
     * @return {@code boolean}
     * @author Fan
     * @since 2025/2/19 9:28
     */
    public static boolean isNotBlank(char ch) {
        return !isBlank(ch);
    }
}
