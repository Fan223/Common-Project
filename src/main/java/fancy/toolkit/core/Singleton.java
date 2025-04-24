package fancy.toolkit.core;

import fancy.toolkit.reflect.ReflectUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 单例工厂类.
 *
 * @author Fan
 * @since 2025/2/19 14:23
 */
public class Singleton {

    private static final Map<String, Object> SINGLETON_MAP = new ConcurrentHashMap<>();

    private Singleton() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * 获取单例对象.
     *
     * @param clazz {@link Class}
     * @return {@link T}
     * @author Fan
     * @since 2025/2/19 14:41
     */
    public static <T> T getInstance(Class<T> clazz) {
        return clazz.cast(SINGLETON_MAP.computeIfAbsent(clazz.getName(), ReflectUtils::newInstance));
    }
}
