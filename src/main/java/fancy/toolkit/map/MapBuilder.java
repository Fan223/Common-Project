package fancy.toolkit.map;

import fancy.toolkit.builder.Builder;

import java.util.Map;

/**
 * {@link Map} 建造者类.
 *
 * @author Fan
 * @since 2025/2/19 10:05
 */
public record MapBuilder<K, V>(Map<K, V> map) implements Builder<Map<K, V>> {

    public MapBuilder() {
        this(false);
    }

    public MapBuilder(boolean isLinked) {
        this(MapUtils.hashMap(isLinked));
    }

    /**
     * 添加键值对.
     *
     * @param key   键
     * @param value 值
     * @return {@link MapBuilder}
     * @author Fan
     * @since 2025/2/19 10:16
     */
    public MapBuilder<K, V> put(K key, V value) {
        map.put(key, value);
        return this;
    }

    /**
     * 根据条件添加键值对.
     *
     * @param condition 条件
     * @param key       键
     * @param value     值
     * @return {@link MapBuilder}
     * @author Fan
     * @since 2025/2/19 10:16
     */
    public MapBuilder<K, V> put(boolean condition, K key, V value) {
        return condition ? put(key, value) : this;
    }

    /**
     * 添加所有键值对.
     *
     * @param map {@link Map}
     * @return {@link MapBuilder}
     * @author Fan
     * @since 2025/2/19 10:16
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
