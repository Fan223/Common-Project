package fancy.toolkit.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * {@link Map} 工具类.
 *
 * @author Fan
 * @since 2025/2/19 9:49
 */
public class MapUtils {

    private MapUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * 判断是否为空.
     *
     * @param map {@link Map}
     * @return {@code boolean}
     * @author Fan
     * @since 2025/2/19 9:53
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return null == map || map.isEmpty();
    }

    /**
     * 判断是否不为空.
     *
     * @param map {@link Map}
     * @return {@code boolean}
     * @author Fan
     * @since 2025/2/19 9:54
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     * 创建 {@link LinkedHashMap} 或 {@link HashMap}.
     *
     * @param isLinked 是否为 {@link LinkedHashMap}
     * @return {@link Map}
     * @author Fan
     * @since 2025/2/19 9:58
     */
    public static <K, V> Map<K, V> hashMap(boolean isLinked) {
        return isLinked ? new LinkedHashMap<>() : new HashMap<>();
    }

    /**
     * 通过键值对构建 {@link HashMap}.
     *
     * @param key   键
     * @param value 值
     * @return {@link Map}
     * @author Fan
     * @since 2025/2/19 10:02
     */
    public static <K, V> Map<K, V> of(K key, V value) {
        return of(false, key, value);
    }

    /**
     * 通过键值对构建 {@link LinkedHashMap} 或 {@link HashMap}.
     *
     * @param isLinked 是否为 {@link LinkedHashMap}
     * @param key      键
     * @param value    值
     * @return {@link Map}
     * @author Fan
     * @since 2025/2/19 10:02
     */
    public static <K, V> Map<K, V> of(boolean isLinked, K key, V value) {
        Map<K, V> map = hashMap(isLinked);
        map.put(key, value);
        return map;
    }

    /**
     * 创建 {@link MapBuilder}.
     *
     * @return {@link MapBuilder}
     * @author Fan
     * @since 2025/2/19 10:33
     */
    public static <K, V> MapBuilder<K, V> builder() {
        return new MapBuilder<>();
    }

    /**
     * 通过键值对构建 {@link MapBuilder}.
     *
     * @param key   键
     * @param value 值
     * @return {@link MapBuilder}
     * @author Fan
     * @since 2025/2/19 10:34
     */
    public static <K, V> MapBuilder<K, V> builder(K key, V value) {
        return new MapBuilder<>(of(key, value));
    }
}
