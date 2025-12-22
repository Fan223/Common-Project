package fan.fancy.toolkit.builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * {@link MapBuilder} 测试类.
 *
 * @author Fan
 */
class MapBuilderTest {

    @Nested
    class OfTests {
        @Test
        void of_noArgs_returnsEmptyMap() {
            Map<String, String> map = MapBuilder.<String, String>of().build();
            Assertions.assertNotNull(map);
            Assertions.assertTrue(map.isEmpty());
        }

        @Test
        void of_withKeyValue_returnsMapWithSingleEntry() {
            Map<String, Integer> map = MapBuilder.of("key1", 100).build();
            Assertions.assertEquals(1, map.size());
            Assertions.assertEquals(100, map.get("key1"));
        }

        @Test
        void ofLinked_noArgs_returnsEmptyLinkedHashMap() {
            Map<String, String> map = MapBuilder.<String, String>ofLinked().build();
            Assertions.assertNotNull(map);
            Assertions.assertInstanceOf(LinkedHashMap.class, map);
            Assertions.assertTrue(map.isEmpty());
        }

        @Test
        void ofLinked_withKeyValue_returnsLinkedHashMapWithSingleEntry() {
            Map<String, Integer> map = MapBuilder.ofLinked("key1", 200).build();
            Assertions.assertInstanceOf(LinkedHashMap.class, map);
            Assertions.assertEquals(1, map.size());
            Assertions.assertEquals(200, map.get("key1"));
        }
    }

    @Nested
    class PutTests {
        @Test
        void put_multipleEntries_returnsMapWithAllEntries() {
            Map<String, Integer> map = MapBuilder.<String, Integer>of()
                    .put("a", 1)
                    .put("b", 2)
                    .put("c", 3)
                    .build();
            Assertions.assertEquals(3, map.size());
            Assertions.assertEquals(1, map.get("a"));
            Assertions.assertEquals(2, map.get("b"));
            Assertions.assertEquals(3, map.get("c"));
        }

        @Test
        void put_conditionTrue_addsEntryToMap() {
            Map<String, Integer> map = MapBuilder.<String, Integer>of()
                    .put(true, "key1", 100)
                    .put(true, "key2", 200)
                    .build();
            Assertions.assertEquals(2, map.size());
            Assertions.assertEquals(100, map.get("key1"));
            Assertions.assertEquals(200, map.get("key2"));
        }

        @Test
        void put_conditionFalse_skipsEntry() {
            Map<String, Integer> map = MapBuilder.<String, Integer>of()
                    .put("key1", 100)
                    .put(false, "key2", 200)
                    .put("key3", 300)
                    .build();
            Assertions.assertEquals(2, map.size());
            Assertions.assertEquals(100, map.get("key1"));
            Assertions.assertNull(map.get("key2"));
            Assertions.assertEquals(300, map.get("key3"));
        }

        @Test
        void putIfNotNull_nonNullValue_addsEntryToMap() {
            Map<String, String> map = MapBuilder.<String, String>of()
                    .putIfNotNull("key1", "value1")
                    .putIfNotNull("key2", "value2")
                    .build();
            Assertions.assertEquals(2, map.size());
            Assertions.assertEquals("value1", map.get("key1"));
            Assertions.assertEquals("value2", map.get("key2"));
        }

        @Test
        void putIfNotNull_nullValue_skipsEntry() {
            Map<String, String> map = MapBuilder.<String, String>of()
                    .putIfNotNull("key1", "value1")
                    .putIfNotNull("key2", null)
                    .putIfNotNull("key3", "value3")
                    .build();
            Assertions.assertEquals(2, map.size());
            Assertions.assertEquals("value1", map.get("key1"));
            Assertions.assertNull(map.get("key2"));
            Assertions.assertEquals("value3", map.get("key3"));
        }

        @Test
        void putAll_existingMap_mergesAllEntries() {
            Map<String, Integer> existingMap = new HashMap<>();
            existingMap.put("x", 10);
            existingMap.put("y", 20);

            Map<String, Integer> map = MapBuilder.<String, Integer>of()
                    .put("a", 1)
                    .putAll(existingMap)
                    .build();

            Assertions.assertEquals(3, map.size());
            Assertions.assertEquals(1, map.get("a"));
            Assertions.assertEquals(10, map.get("x"));
            Assertions.assertEquals(20, map.get("y"));
        }
    }
}
