package fan.fancy.toolkit.reflect;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * {@link ArrayUtils} 测试类.
 *
 * @author Fan
 */
class ArrayUtilsTest {

    @Test
    void isArray_arrayTypes_returnsTrue() {
        Assertions.assertTrue(ArrayUtils.isArray(new int[]{1, 2, 3}));
        Assertions.assertTrue(ArrayUtils.isArray(new String[]{"a", "b"}));
        Assertions.assertTrue(ArrayUtils.isArray(new Object[]{}));
    }

    @Test
    void isArray_nonArrayTypes_returnsFalse() {
        Assertions.assertFalse(ArrayUtils.isArray(null));
        Assertions.assertFalse(ArrayUtils.isArray("string"));
        Assertions.assertFalse(ArrayUtils.isArray(123));
    }

    @Test
    void getLength_arrays_returnsLength() {
        Assertions.assertEquals(3, ArrayUtils.getLength(new int[]{1, 2, 3}));
        Assertions.assertEquals(2, ArrayUtils.getLength(new String[]{"a", "b"}));
        Assertions.assertEquals(0, ArrayUtils.getLength(new Object[]{}));
    }

    @Test
    void getLength_nonArray_returnsZero() {
        Assertions.assertEquals(0, ArrayUtils.getLength(null));
        Assertions.assertEquals(0, ArrayUtils.getLength("string"));
        Assertions.assertEquals(0, ArrayUtils.getLength(123));
    }

    @Test
    void of_noArgs_returnsEmptyArray() {
        String[] array = ArrayUtils.of();
        Assertions.assertNotNull(array);
        Assertions.assertEquals(0, array.length);
    }

    @Test
    void of_withElements_returnsArray() {
        String[] array = ArrayUtils.of("a", "b", "c");

        Assertions.assertEquals(3, array.length);
        Assertions.assertEquals("a", array[0]);
        Assertions.assertEquals("b", array[1]);
        Assertions.assertEquals("c", array[2]);
    }

    @Test
    void of_withNullElements_allowsNull() {
        String[] array = ArrayUtils.of("a", null, "c");

        Assertions.assertEquals(3, array.length);
        Assertions.assertEquals("a", array[0]);
        Assertions.assertNull(array[1]);
        Assertions.assertEquals("c", array[2]);
    }

    @Nested
    class IsEmptyTests {
        @Test
        void isEmpty_emptyArrays_returnsTrue() {
            Assertions.assertTrue(ArrayUtils.isEmpty(new int[]{}));
            Assertions.assertTrue(ArrayUtils.isEmpty(new String[]{}));
        }

        @Test
        void isEmpty_nonEmptyArrays_returnsFalse() {
            Assertions.assertFalse(ArrayUtils.isEmpty(new int[]{1}));
            Assertions.assertFalse(ArrayUtils.isEmpty(new String[]{"a"}));
        }

        @Test
        void isEmpty_nonArray_returnsTrue() {
            Assertions.assertTrue(ArrayUtils.isEmpty(null));
            Assertions.assertTrue(ArrayUtils.isEmpty("string"));
        }

        @Test
        void isNotEmpty_emptyArrays_returnsFalse() {
            Assertions.assertFalse(ArrayUtils.isNotEmpty(new int[]{}));
            Assertions.assertFalse(ArrayUtils.isNotEmpty(null));
        }

        @Test
        void isNotEmpty_nonEmptyArrays_returnsTrue() {
            Assertions.assertTrue(ArrayUtils.isNotEmpty(new int[]{1, 2}));
            Assertions.assertTrue(ArrayUtils.isNotEmpty(new String[]{"a"}));
        }
    }
}
