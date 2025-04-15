package fancy.toolkit.collection;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * {@link Collection} 工具类.
 *
 * @author Fan
 * @since 2025/2/17 15:41
 */
public class CollectionUtils {

    private CollectionUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * 判断是否为空.
     *
     * @param coll {@link Collection}
     * @return {@code boolean}
     * @author Fan
     * @since 2025/2/17 15:49
     */
    public static boolean isEmpty(Collection<?> coll) {
        return null == coll || coll.isEmpty();
    }

    /**
     * 判断是否不为空.
     *
     * @param coll {@link Collection}
     * @return {@code boolean}
     * @author Fan
     * @since 2025/2/17 15:49
     */
    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    /**
     * 使用分隔符 {@code ,} 拼接成字符串.
     *
     * @param coll {@link Collection}
     * @return {@link String}
     * @author Fan
     * @since 2025/2/17 15:50
     */
    public static String join(Collection<?> coll) {
        return join(coll, ",");
    }

    /**
     * 使用指定分隔符拼接成字符串.
     *
     * @param coll      {@link Collection}
     * @param delimiter 分隔符
     * @return {@link String}
     * @author Fan
     * @since 2025/2/17 15:50
     */
    public static String join(Collection<?> coll, CharSequence delimiter) {
        return coll.parallelStream().map(Object::toString).collect(Collectors.joining(delimiter));
    }

    /**
     * 使用指定分隔符拼接成字符串, 并加上指定的前缀和后缀.
     *
     * @param coll      {@link Collection}
     * @param delimiter 分隔符
     * @param prefix    前缀
     * @param suffix    后缀
     * @return {@link String}
     * @author Fan
     * @since 2025/2/17 15:50
     */
    public static String join(Collection<?> coll, String delimiter, String prefix, String suffix) {
        return coll.parallelStream().map(Object::toString).collect(Collectors.joining(delimiter, prefix, suffix));
    }
}
