package fan.fancy.toolkit.reflect;

import lombok.experimental.UtilityClass;

import java.lang.reflect.Array;

/**
 * 数组工具类.
 *
 * @author Fan
 */
@UtilityClass
public class ArrayUtils {

    /**
     * 判断是否为数组.
     *
     * @param obj {@link Object}
     * @return {@code boolean}
     */
    public static boolean isArray(Object obj) {
        return obj != null && obj.getClass().isArray();
    }

    /**
     * 获取数组长度, 空或非数组直接返回 0.
     *
     * @param obj {@link Object}
     * @return {@code int}
     */
    public static int getLength(Object obj) {
        return isArray(obj) ? Array.getLength(obj) : 0;
    }

    /**
     * 判断数组是否为空.
     *
     * @param obj {@link Object}
     * @return {@code boolean}
     */
    public static boolean isEmpty(Object obj) {
        return getLength(obj) == 0;
    }

    /**
     * 判断数组是否不为空.
     *
     * @param obj {@link Object}
     * @return {@code boolean}
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 返回一个包含指定元素的数组.
     *
     * @param a   元素
     * @param <T> 元素类型
     * @return {@code T[]}
     */
    @SafeVarargs
    public static <T> T[] of(T... a) {
        return a;
    }
}
