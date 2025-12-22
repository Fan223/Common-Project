package fan.fancy.toolkit.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@link Singleton} 测试类.
 *
 * @author Fan
 */
class SingletonTest {

    @Test
    void getInstance_firstCall_createsNewInstance() {
        TestClass instance = Singleton.getInstance(TestClass.class);

        Assertions.assertNotNull(instance);
        Assertions.assertInstanceOf(TestClass.class, instance);
    }

    @Test
    void getInstance_multipleCalls_returnsSameInstance() {
        TestClass instance1 = Singleton.getInstance(TestClass.class);
        TestClass instance2 = Singleton.getInstance(TestClass.class);

        Assertions.assertSame(instance1, instance2);
    }

    public static class TestClass {
    }
}
