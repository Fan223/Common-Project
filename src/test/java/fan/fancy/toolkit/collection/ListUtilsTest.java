package fan.fancy.toolkit.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link ListUtils} 测试类.
 *
 * @author Fan
 */
class ListUtilsTest {

    @Nested
    class OfTests {
        @Test
        void of_noElements_returnsEmptyList() {
            List<String> list = ListUtils.of();

            Assertions.assertNotNull(list);
            Assertions.assertInstanceOf(ArrayList.class, list);
            Assertions.assertTrue(list.isEmpty());
        }

        @Test
        void of_singleElement_returnsListWithOneElement() {
            List<String> list = ListUtils.of("a");

            Assertions.assertEquals(1, list.size());
            Assertions.assertEquals("a", list.getFirst());
        }

        @Test
        void of_multipleElements_returnsListWithAllElements() {
            List<String> list = ListUtils.of("a", "b", "c");

            Assertions.assertEquals(3, list.size());
            Assertions.assertEquals("a", list.get(0));
            Assertions.assertEquals("b", list.get(1));
            Assertions.assertEquals("c", list.get(2));
        }

        @Test
        void of_withNullElement_allowsNullInList() {
            List<String> list = ListUtils.of("a", null, "c");

            Assertions.assertEquals(3, list.size());
            Assertions.assertEquals("a", list.get(0));
            Assertions.assertNull(list.get(1));
            Assertions.assertEquals("c", list.get(2));
        }

        @Test
        void of_withNumbers_returnsListOfNumbers() {
            List<Integer> list = ListUtils.of(1, 2, 3, 4, 5);

            Assertions.assertEquals(5, list.size());
            Assertions.assertEquals(1, list.get(0));
            Assertions.assertEquals(5, list.get(4));
        }

        @Test
        void of_returnsMutableList_allowsModification() {
            List<String> list = ListUtils.of("a", "b");

            list.add("c");
            Assertions.assertEquals(3, list.size());

            list.removeFirst();
            Assertions.assertEquals(2, list.size());
            Assertions.assertEquals("b", list.get(0));
        }
    }
}