package fan.fancy.toolkit.collection;

import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * {@link Collection} 工具类.
 *
 * @author Fan
 */
@UtilityClass
public class CollectionUtils {

    /**
     * 判断 {@link Collection} 是否为空.
     *
     * @param coll {@link Collection}
     * @return {@code boolean}
     */
    public static boolean isEmpty(Collection<?> coll) {
        return coll == null || coll.isEmpty();
    }

    /**
     * 判断 {@link Collection} 是否不为空.
     *
     * @param coll {@link Collection}
     * @return {@code boolean}
     */
    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    /**
     * {@link Collection} 元素拼接.
     *
     * @param coll {@link Collection}
     * @return {@link String}
     */
    public static String join(Collection<?> coll) {
        return join(coll, "");
    }

    /**
     * 使用指定分隔符进行元素拼接.
     *
     * @param coll      {@link Collection}
     * @param delimiter 分隔符
     * @return {@link String}
     */
    public static String join(Collection<?> coll, CharSequence delimiter) {
        return join(coll, delimiter, "", "");
    }

    /**
     * 使用指定分隔符进行元素拼接, 最后加上指定前缀和后缀.
     *
     * @param coll      {@link Collection}
     * @param delimiter 分隔符
     * @param prefix    前缀
     * @param suffix    后缀
     * @return {@link String}
     */
    public static String join(Collection<?> coll, CharSequence delimiter, CharSequence prefix, CharSequence suffix) {
        if (isEmpty(coll)) {
            return "";
        }
        return coll.stream()
                .map(o -> o == null ? "" : o.toString())
                .collect(Collectors.joining(delimiter, prefix, suffix));
    }

    /**
     * 使用指定分隔符进行元素拼接, 每个元素加上指定前缀和后缀.
     *
     * @param coll      {@link Collection}
     * @param delimiter 分隔符
     * @param prefix    前缀
     * @param suffix    后缀
     * @return {@link String}
     */
    public static String joinEach(Collection<?> coll, CharSequence delimiter, CharSequence prefix, CharSequence suffix) {
        if (isEmpty(coll)) {
            return "";
        }
        return coll.stream()
                .map(obj -> obj == null ? "" : prefix + obj.toString() + suffix)
                .collect(Collectors.joining(delimiter));
    }
}
