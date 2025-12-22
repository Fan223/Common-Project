package fan.fancy.toolkit.factory;

import fan.fancy.toolkit.reflect.ReflectUtils;
import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 单例工厂类.
 *
 * @author Fan
 */
@UtilityClass
public class Singleton {

    /**
     * 单例缓存.
     */
    private static final Map<String, Object> SINGLETON_MAP = new ConcurrentHashMap<>();

    /**
     * 获取单例实例.
     *
     * @param clazz {@link Class}
     * @param <T>   泛型类型
     * @return {@link T}
     */
    public static <T> T getInstance(Class<T> clazz) {
        return clazz.cast(SINGLETON_MAP.computeIfAbsent(clazz.getName(), ReflectUtils::getInstance));
    }
}
