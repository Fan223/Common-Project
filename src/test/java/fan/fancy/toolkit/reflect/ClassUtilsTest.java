package fan.fancy.toolkit.reflect;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@link ClassUtils} 测试类.
 *
 * @author Fan
 */
class ClassUtilsTest {

    @Test
    void isWrapper_wrapperClasses_returnsTrue() {
        Assertions.assertTrue(ClassUtils.isWrapper(Integer.class));
        Assertions.assertTrue(ClassUtils.isWrapper(Long.class));
        Assertions.assertTrue(ClassUtils.isWrapper(Boolean.class));
        Assertions.assertTrue(ClassUtils.isWrapper(Double.class));
    }

    @Test
    void isWrapper_nonWrapperClasses_returnsFalse() {
        Assertions.assertFalse(ClassUtils.isWrapper(int.class));
        Assertions.assertFalse(ClassUtils.isWrapper(String.class));
        Assertions.assertFalse(ClassUtils.isWrapper(Object.class));
    }

    @Test
    void toPrimitive_wrapperClass_returnsPrimitiveClass() {
        Assertions.assertEquals(int.class, ClassUtils.toPrimitive(Integer.class));
        Assertions.assertEquals(boolean.class, ClassUtils.toPrimitive(Boolean.class));
        Assertions.assertEquals(double.class, ClassUtils.toPrimitive(Double.class));
    }

    @Test
    void toPrimitive_nonWrapperClass_returnsNull() {
        Assertions.assertNull(ClassUtils.toPrimitive(String.class));
    }

    @Test
    void toWrapper_primitiveClass_returnsWrapperClass() {
        Assertions.assertEquals(Integer.class, ClassUtils.toWrapper(int.class));
        Assertions.assertEquals(Boolean.class, ClassUtils.toWrapper(boolean.class));
        Assertions.assertEquals(Double.class, ClassUtils.toWrapper(double.class));
    }

    @Test
    void toWrapper_nonPrimitiveClass_returnsNull() {
        Assertions.assertNull(ClassUtils.toWrapper(String.class));
    }

    @Test
    void isAssignable_sameClass_returnsTrue() {
        Assertions.assertTrue(ClassUtils.isAssignable(String.class, String.class));
        Assertions.assertTrue(ClassUtils.isAssignable(int.class, int.class));
    }

    @Test
    void isAssignable_inheritanceRelation_returnsTrue() {
        Assertions.assertTrue(ClassUtils.isAssignable(Integer.class, Number.class));
        Assertions.assertTrue(ClassUtils.isAssignable(String.class, Object.class));
    }

    @Test
    void isAssignable_primitiveWidening_returnsTrue() {
        Assertions.assertTrue(ClassUtils.isAssignable(byte.class, int.class));
        Assertions.assertTrue(ClassUtils.isAssignable(int.class, long.class));
        Assertions.assertTrue(ClassUtils.isAssignable(float.class, double.class));
    }

    @Test
    void isAssignable_primitiveAndWrapper_returnsTrue() {
        Assertions.assertTrue(ClassUtils.isAssignable(Integer.class, int.class));
        Assertions.assertTrue(ClassUtils.isAssignable(int.class, Integer.class));
    }

    @Test
    void isAssignable_nullToReferenceType_returnsTrue() {
        Assertions.assertTrue(ClassUtils.isAssignable(null, String.class));
        Assertions.assertTrue(ClassUtils.isAssignable(null, Object.class));
    }

    @Test
    void isAssignable_nullToPrimitiveType_returnsFalse() {
        Assertions.assertFalse(ClassUtils.isAssignable(null, int.class));
        Assertions.assertFalse(ClassUtils.isAssignable(null, boolean.class));
    }

    @Test
    void isAssignable_toNull_returnsFalse() {
        Assertions.assertFalse(ClassUtils.isAssignable(String.class, null));
        Assertions.assertFalse(ClassUtils.isAssignable(int.class, null));
    }

    @Test
    void isAssignable_incompatibleTypes_returnsFalse() {
        Assertions.assertFalse(ClassUtils.isAssignable(String.class, Integer.class));
        Assertions.assertFalse(ClassUtils.isAssignable(int.class, boolean.class));
    }

    @Test
    void getClass_validClassName_returnsClass() {
        Class<?> clazz = ClassUtils.getClass("java.lang.String");
        Assertions.assertEquals(String.class, clazz);
    }

    @Test
    void getClass_invalidClassName_throwsException() {
        Assertions.assertThrows(ReflectException.class,
                () -> ClassUtils.getClass("com.invalid.ClassName"));
    }

    @Test
    void getClasses_nullArray_returnsEmptyArray() {
        Class<?>[] classes = ClassUtils.getClasses((Object[]) null);
        Assertions.assertNotNull(classes);
        Assertions.assertEquals(0, classes.length);
    }

    @Test
    void getClasses_mixedObjects_returnsClassArray() {
        Class<?>[] classes = ClassUtils.getClasses("test", 123, null, true);

        Assertions.assertEquals(4, classes.length);
        Assertions.assertEquals(String.class, classes[0]);
        Assertions.assertEquals(Integer.class, classes[1]);
        Assertions.assertNull(classes[2]);
        Assertions.assertEquals(Boolean.class, classes[3]);
    }
}
