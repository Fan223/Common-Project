package fan.fancy.toolkit.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * {@link MapUtils} 测试类.
 *
 * @author Fan
 */
class MapUtilsTest {

    @Nested
    class IsEmptyTests {
        @Test
        void isEmpty_nullMap_returnsTrue() {
            Assertions.assertTrue(MapUtils.isEmpty(null));
        }

        @Test
        void isEmpty_emptyMap_returnsTrue() {
            Assertions.assertTrue(MapUtils.isEmpty(Collections.emptyMap()));
        }

        @Test
        void isEmpty_nonEmptyMap_returnsFalse() {
            Map<String, Integer> map = new HashMap<>();
            map.put("key", 1);
            Assertions.assertFalse(MapUtils.isEmpty(map));
        }

        @Test
        void isNotEmpty_nullMap_returnsFalse() {
            Assertions.assertFalse(MapUtils.isNotEmpty(null));
        }

        @Test
        void isNotEmpty_emptyMap_returnsFalse() {
            Assertions.assertFalse(MapUtils.isNotEmpty(Collections.emptyMap()));
        }

        @Test
        void isNotEmpty_nonEmptyMap_returnsTrue() {
            Map<String, Integer> map = new HashMap<>();
            map.put("key", 1);
            Assertions.assertTrue(MapUtils.isNotEmpty(map));
        }
    }

    @Nested
    class OfTests {
        @Test
        void of_withKeyValue_returnsHashMapWithSingleEntry() {
            Map<String, Integer> map = MapUtils.of("key1", 100);

            Assertions.assertNotNull(map);
            Assertions.assertInstanceOf(HashMap.class, map);
            Assertions.assertEquals(1, map.size());
            Assertions.assertEquals(100, map.get("key1"));
        }

        @Test
        void of_withNullKey_allowsNullKey() {
            Map<String, Integer> map = MapUtils.of(null, 100);

            Assertions.assertEquals(1, map.size());
            Assertions.assertEquals(100, map.get(null));
        }

        @Test
        void of_withNullValue_allowsNullValue() {
            Map<String, Integer> map = MapUtils.of("key1", null);

            Assertions.assertEquals(1, map.size());
            Assertions.assertTrue(map.containsKey("key1"));
            Assertions.assertNull(map.get("key1"));
        }

        @Test
        void ofLinked_withKeyValue_returnsLinkedHashMapWithSingleEntry() {
            Map<String, Integer> map = MapUtils.ofLinked("key1", 200);

            Assertions.assertNotNull(map);
            Assertions.assertInstanceOf(LinkedHashMap.class, map);
            Assertions.assertEquals(1, map.size());
            Assertions.assertEquals(200, map.get("key1"));
        }

        @Test
        void ofLinked_withNullKey_allowsNullKey() {
            Map<String, Integer> map = MapUtils.ofLinked(null, 200);

            Assertions.assertEquals(1, map.size());
            Assertions.assertEquals(200, map.get(null));
        }

        @Test
        void ofLinked_withNullValue_allowsNullValue() {
            Map<String, Integer> map = MapUtils.ofLinked("key1", null);

            Assertions.assertEquals(1, map.size());
            Assertions.assertTrue(map.containsKey("key1"));
            Assertions.assertNull(map.get("key1"));
        }
    }
}
