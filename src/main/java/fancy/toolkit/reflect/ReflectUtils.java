package fancy.toolkit.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射工具类.
 *
 * @author Fan
 * @since 2025/2/21 10:37
 */
public class ReflectUtils {

    private ReflectUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * 通过 {@link Class} 名称创建 {@link Object}.
     *
     * @param className {@link Class} 名称
     * @param args      构造函数参数
     * @return {@link T}
     * @author Fan
     * @since 2025/2/21 16:42
     */
    public static <T> T newInstance(String className, Object... args) {
        try {
            @SuppressWarnings("unchecked")
            Class<T> clazz = (Class<T>) Class.forName(className);
            return newInstance(clazz, args);
        } catch (ClassNotFoundException e) {
            throw new ReflectException(e);
        }
    }

    /**
     * 通过 {@link Class} 创建 {@link Object}.
     *
     * @param clazz {@link Class}
     * @param args  构造函数参数
     * @return {@link T}
     * @author Fan
     * @since 2025/2/21 16:57
     */
    public static <T> T newInstance(Class<T> clazz, Object... args) {
        try {
            Constructor<T> constructor = getConstructor(clazz, ClassUtils.getClasses(args));
            return constructor.newInstance(args);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new ReflectException(e);
        }
    }

    /**
     * 获取 {@link Class} 中指定参数类型的构造方法.
     *
     * @param clazz          {@link Class}
     * @param parameterTypes 参数类型
     * @return {@link Constructor<T>}
     * @author Fan
     * @since 2025/2/21 16:58
     */
    public static <T> Constructor<T> getConstructor(Class<T> clazz, Class<?>... parameterTypes) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor(parameterTypes);
            // 确保可以调用私有构造函数
            setAccessible(constructor);
            return constructor;
        } catch (NoSuchMethodException e) {
            throw new ReflectException(e);
        }
    }

    /**
     * 设置 {@link Object} 可访问.
     *
     * @param obj {@link Object}
     * @author Fan
     * @since 2025/2/24 8:47
     */
    public static <T extends AccessibleObject> void setAccessible(T obj) {
        obj.setAccessible(true);
    }

    /**
     * 通过方法名获取 {@link Object} 中指定参数的方法.
     *
     * @param obj        {@link Object}
     * @param methodName 方法名
     * @param args       参数
     * @return {@link Method}
     * @author Fan
     * @since 2025/2/24 9:33
     */
    public static Method getMethod(Object obj, String methodName, Object... args) {
        return getMethod(obj.getClass(), methodName, ClassUtils.getClasses(args));
    }

    /**
     * 通过方法名获取 {@link Class} 中指定参数的方法.
     *
     * @param clazz          {@link Class}
     * @param methodName     方法名
     * @param parameterTypes 参数类型
     * @return {@link Method}
     * @author Fan
     * @since 2025/2/24 8:59
     */
    public static Method getMethod(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        try {
            return clazz.getDeclaredMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            throw new ReflectException(e);
        }
    }

    /**
     * 通过方法名执行 {@link Object} 的方法.
     *
     * @param obj        {@link Object}
     * @param methodName 方法名
     * @param args       参数
     * @return {@link T}
     * @author Fan
     * @since 2025/2/24 9:00
     */
    public static <T> T invoke(Object obj, String methodName, Object... args) {
        return invoke(obj, getMethod(obj, methodName, args), args);
    }

    /**
     * 执行 {@link Object} 的方法.
     *
     * @param obj    对象
     * @param method 方法
     * @param args   参数
     * @return {@link T}
     * @author Fan
     * @since 2025/2/24 9:20
     */
    @SuppressWarnings("unchecked")
    public static <T> T invoke(Object obj, Method method, Object... args) {
        try {
            setAccessible(method);
            if (method.isDefault()) {
                MethodHandles.Lookup lookup = MethodHandles.lookup();
                MethodHandle handle = lookup.unreflect(method);
                return (T) handle.invokeWithArguments(args);
            }
            return (T) method.invoke(obj, args);
        } catch (Throwable e) {
            throw new ReflectException(e);
        }
    }
}
