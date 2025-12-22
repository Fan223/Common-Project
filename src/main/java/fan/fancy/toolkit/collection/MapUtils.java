package fan.fancy.toolkit.collection;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * {@link Map} 工具类.
 *
 * @author Fan
 */
@UtilityClass
public class MapUtils {

    /**
     * 判断 {@link Map} 是否为空.
     *
     * @param map {@link Map}
     * @return {@code boolean}
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * 判断 {@link Map} 是否不为空.
     *
     * @param map {@link Map}
     * @return {@code boolean}
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     * 返回一个包含指定键值对的 {@link HashMap}.
     *
     * @param key   键
     * @param value 值
     * @param <K>   键类型
     * @param <V>   值类型
     * @return {@link Map}
     */
    public static <K, V> Map<K, V> of(K key, V value) {
        Map<K, V> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

    /**
     * 返回一个包含指定键值对的 {@link LinkedHashMap}.
     *
     * @param key   键
     * @param value 值
     * @param <K>   键类型
     * @param <V>   值类型
     * @return {@link Map}
     */
    public static <K, V> Map<K, V> ofLinked(K key, V value) {
        Map<K, V> map = new LinkedHashMap<>();
        map.put(key, value);
        return map;
    }
}
