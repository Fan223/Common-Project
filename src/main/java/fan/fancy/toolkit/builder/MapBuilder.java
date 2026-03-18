package fan.fancy.toolkit.builder;

import fan.fancy.toolkit.collection.MapUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * {@link Map} 建造者类.
 *
 * @param <K> 键类型
 * @param <V> 值类型
 * @author Fan
 */
public final class MapBuilder<K, V> implements Builder<Map<K, V>> {

    /**
     * {@link Map} 实例.
     */
    private final Map<K, V> map;

    /**
     * 构造方法, 使用 {@link HashMap} 初始化内部的 {@link Map} 实例.
     */
    private MapBuilder() {
        this.map = new HashMap<>();
    }

    /**
     * 构造方法, 使用指定的 {@link Map} 初始化内部的 {@link Map} 实例.
     *
     * @param map {@link Map}
     */
    private MapBuilder(Map<K, V> map) {
        this.map = map;
    }

    /**
     * 返回使用 {@link HashMap} 创建的 {@link MapBuilder} 实例.
     *
     * @param <K> 键类型
     * @param <V> 值类型
     * @return {@link MapBuilder}
     */
    public static <K, V> MapBuilder<K, V> of() {
        return new MapBuilder<>();
    }

    /**
     * 返回使用包含指定键值对的 {@link HashMap} 创建的 {@link MapBuilder} 实例.
     *
     * @param key   键
     * @param value 值
     * @param <K>   键类型
     * @param <V>   值类型
     * @return {@link MapBuilder}
     */
    public static <K, V> MapBuilder<K, V> of(K key, V value) {
        return new MapBuilder<>(MapUtils.of(key, value));
    }

    /**
     * 返回使用 {@link LinkedHashMap} 创建的 {@link MapBuilder} 实例.
     *
     * @param <K> 键类型
     * @param <V> 值类型
     * @return {@link MapBuilder}
     */
    public static <K, V> MapBuilder<K, V> ofLinked() {
        return new MapBuilder<>(new LinkedHashMap<>());
    }

    /**
     * 返回使用包含指定键值对的 {@link LinkedHashMap} 创建的 {@link MapBuilder} 实例.
     *
     * @param key   键
     * @param value 值
     * @param <K>   键类型
     * @param <V>   值类型
     * @return {@link MapBuilder}
     */
    public static <K, V> MapBuilder<K, V> ofLinked(K key, V value) {
        return new MapBuilder<>(MapUtils.ofLinked(key, value));
    }

    /**
     * 添加键值对.
     *
     * @param key   键
     * @param value 值
     * @return {@link MapBuilder}
     */
    public MapBuilder<K, V> put(K key, V value) {
        map.put(key, value);
        return this;
    }

    /**
     * 条件添加键值对.
     *
     * @param condition 条件
     * @param key       键
     * @param value     值
     * @return {@link MapBuilder}
     */
    public MapBuilder<K, V> put(boolean condition, K key, V value) {
        return condition ? put(key, value) : this;
    }

    /**
     * 非空添加键值对.
     *
     * @param key   键
     * @param value 值
     * @return {@link MapBuilder}
     */
    public MapBuilder<K, V> putIfNotNull(K key, V value) {
        return value != null ? put(key, value) : this;
    }

    /**
     * 添加指定 {@link Map} 的所有键值对.
     *
     * @param map {@link Map}
     * @return {@link MapBuilder}
     */
    public MapBuilder<K, V> putAll(Map<? extends K, ? extends V> map) {
        this.map.putAll(map);
        return this;
    }

    @Override
    public Map<K, V> build() {
        return map;
    }
}
