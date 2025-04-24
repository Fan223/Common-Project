package fancy.toolkit.reflect;

/**
 * {@link Class} 工具类.
 *
 * @author Fan
 * @since 2025/2/21 16:35
 */
public class ClassUtils {

    private ClassUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * 通过 {@link Object} 获取对应的 {@link Class}.
     *
     * @param obj {@link Object}
     * @return {@link Class<T>}
     * @author Fan
     * @since 2025/2/21 17:03
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getClass(T obj) {
        return null == obj ? null : (Class<T>) obj.getClass();
    }

    /**
     * 通过 {@link Object} 数组获取对应的 {@link Class} 数组.
     *
     * @param objects {@link Object} 数组
     * @return {@code Class<?>[]}
     * @author Fan
     * @since 2025/2/24 8:43
     */
    public static Class<?>[] getClasses(Object... objects) {
        Class<?>[] classes = new Class<?>[objects.length];
        for (int i = 0; i < objects.length; i++) {
            classes[i] = objects[i].getClass();
        }
        return classes;
    }
}
