package fancy.toolkit.text;

/**
 * {@link String} 工具类.
 *
 * @author Fan
 * @since 2025/2/17 16:12
 */
public class StringUtils {

    private StringUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * 判断是否为空.
     *
     * @param cs {@link CharSequence}
     * @return {@code boolean}
     * @author Fan
     * @since 2025/2/17 16:25
     */
    public static boolean isEmpty(CharSequence cs) {
        return null == cs || cs.isEmpty();
    }

    /**
     * 判断是否不为空.
     *
     * @param cs {@link CharSequence}
     * @return {@code boolean}
     * @author Fan
     * @since 2025/2/17 16:25
     */
    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * 判断是否为空白.
     *
     * @param cs {@link CharSequence}
     * @return {@code boolean}
     * @author Fan
     * @since 2025/2/17 16:25
     */
    public static boolean isBlank(CharSequence cs) {
        return null == cs || cs.toString().isBlank();
    }

    /**
     * 判断是否不为空白.
     *
     * @param cs {@link CharSequence}
     * @return {@code boolean}
     * @author Fan
     * @since 2025/2/17 16:26
     */
    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    /**
     * 拼接字符串.
     *
     * @param cs {@link CharSequence}
     * @return {@link String}
     * @author Fan
     * @since 2025/3/6 15:45
     */
    public static String concat(CharSequence... cs) {
        StringBuilder builder = new StringBuilder();
        for (CharSequence c : cs) {
            builder.append(c);
        }
        return builder.toString();
    }

    /**
     * 使用指定分隔符拼接成字符串.
     *
     * @param delimiter 分隔符
     * @param cs        {@link CharSequence}
     * @return {@link String}
     * @author Fan
     * @since 2025/2/17 16:30
     */
    public static String join(CharSequence delimiter, CharSequence... cs) {
        return String.join(delimiter, cs);
    }

    /**
     * 移除前缀.
     *
     * @param cs     {@link CharSequence}
     * @param prefix 前缀
     * @return {@link String}
     * @author Fan
     * @since 2025/2/24 11:17
     */
    public static String removePrefix(CharSequence cs, CharSequence prefix) {
        if (isEmpty(cs) || isEmpty(prefix)) {
            return toString(cs);
        }

        String str = cs.toString();
        if (str.startsWith(prefix.toString())) {
            return str.substring(prefix.length());
        }
        return str;
    }

    /**
     * {@link CharSequence} 转 {@link String}.
     *
     * @param cs {@link CharSequence}
     * @return {@link String}
     * @author Fan
     * @since 2025/2/24 11:12
     */
    public static String toString(CharSequence cs) {
        return null == cs ? null : cs.toString();
    }

    /**
     * 首字母小写.
     *
     * @param cs {@link CharSequence}
     * @return {@link String}
     * @author Fan
     * @since 2025/2/24 11:48
     */
    public static String lowerFirst(CharSequence cs) {
        if (isEmpty(cs)) {
            return toString(cs);
        }
        return Character.toLowerCase(cs.charAt(0)) + cs.subSequence(1, cs.length()).toString();
    }

    /**
     * 去除前缀并首字母小写.
     *
     * @param cs     {@link CharSequence}
     * @param prefix 前缀
     * @return {@link String}
     * @author Fan
     * @since 2025/2/24 11:48
     */
    public static String removePrefixAndLowerFirst(CharSequence cs, CharSequence prefix) {
        return lowerFirst(removePrefix(cs, prefix));
    }
}
