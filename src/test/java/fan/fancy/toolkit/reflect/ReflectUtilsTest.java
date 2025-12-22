package fan.fancy.toolkit.reflect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * {@link ReflectUtils} 测试类.
 *
 * @author Fan
 */
class ReflectUtilsTest {

    @Test
    void getInstance_withClassName_createsInstance() {
        Object instance = ReflectUtils.getInstance("java.lang.String");
        Assertions.assertNotNull(instance);
        Assertions.assertInstanceOf(String.class, instance);
    }

    @Test
    void getInstance_withClassAndArgs_createsInstanceWithArgs() {
        String instance = ReflectUtils.getInstance(String.class, "test");
        Assertions.assertEquals("test", instance);
    }

    @Test
    void getInstance_noArgsConstructor_createsInstance() {
        TestClass instance = ReflectUtils.getInstance(TestClass.class);
        Assertions.assertNotNull(instance);
    }

    @Test
    void getInstance_withArgsConstructor_createsInstanceWithArgs() {
        TestClass instance = ReflectUtils.getInstance(TestClass.class, "name", 100);
        Assertions.assertEquals("name", instance.name);
        Assertions.assertEquals(100, instance.value);
    }

    @Test
    void getInstance_invalidClassName_throwsException() {
        Assertions.assertThrows(ReflectException.class,
                () -> ReflectUtils.getInstance("com.invalid.ClassName"));
    }

    @Test
    void getConstructor_noArgs_returnsConstructor() {
        Constructor<TestClass> constructor = ReflectUtils.getConstructor(TestClass.class);
        Assertions.assertNotNull(constructor);
    }

    @Test
    void getConstructor_withArgs_returnsMatchingConstructor() {
        Constructor<TestClass> constructor = ReflectUtils.getConstructor(TestClass.class, "test", 50);
        Assertions.assertNotNull(constructor);
        Assertions.assertEquals(2, constructor.getParameterCount());
    }

    @Test
    void getConstructor_noMatchingConstructor_throwsException() {
        Assertions.assertThrows(ReflectException.class,
                () -> ReflectUtils.getConstructor(TestClass.class, 123, 456, 789));
    }

    @Test
    void getMethod_withObjectAndMethodName_returnsMethod() {
        TestClass obj = new TestClass();
        Method method = ReflectUtils.getMethod(obj, "getName");

        Assertions.assertNotNull(method);
        Assertions.assertEquals("getName", method.getName());
    }

    @Test
    void getMethod_withClassAndMethodName_returnsMethod() {
        Method method = ReflectUtils.getMethod(TestClass.class, "setName", "test");
        Assertions.assertNotNull(method);
        Assertions.assertEquals("setName", method.getName());
    }

    @Test
    void getMethod_privateMethod_returnsAccessibleMethod() {
        Method method = ReflectUtils.getMethod(TestClass.class, "privateMethod");
        Assertions.assertNotNull(method);
        Assertions.assertTrue(method.canAccess(new TestClass()));
    }

    @Test
    void getMethod_nonExistentMethod_throwsException() {
        Assertions.assertThrows(ReflectException.class,
                () -> ReflectUtils.getMethod(TestClass.class, "nonExistentMethod"));
    }

    @Test
    void invoke_withMethodName_invokesMethod() {
        TestClass obj = new TestClass("test", 100);
        String result = ReflectUtils.invoke(obj, "getName");
        Assertions.assertEquals("test", result);
    }

    @Test
    void invoke_withMethodObject_invokesMethod() {
        TestClass obj = new TestClass();
        Method method = ReflectUtils.getMethod(obj, "setValue", 200);
        ReflectUtils.invoke(obj, method, 200);

        Assertions.assertEquals(200, obj.value);
    }

    @Test
    void invoke_privateMethod_invokesSuccessfully() {
        TestClass obj = new TestClass();
        String result = ReflectUtils.invoke(obj, "privateMethod");
        Assertions.assertEquals("private", result);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TestClass {

        private String name;

        private int value;

        private String privateMethod() {
            return "private";
        }
    }
}
