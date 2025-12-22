package fan.fancy.toolkit.lang;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@link LambdaUtils} 测试类.
 *
 * @author Fan
 */
class LambdaUtilsTest {

    @Test
    void getMethodName_getterMethod_returnsMethodName() {
        String methodName = LambdaUtils.getMethodName(TestEntity::getName);
        Assertions.assertEquals("getName", methodName);
    }

    @Test
    void getMethodName_isMethod_returnsMethodName() {
        String methodName = LambdaUtils.getMethodName(TestEntity::isActive);
        Assertions.assertEquals("isActive", methodName);
    }

    @Test
    void getFieldName_getterMethod_returnsFieldName() {
        String fieldName = LambdaUtils.getFieldName(TestEntity::getName);
        Assertions.assertEquals("name", fieldName);
    }

    @Test
    void getFieldName_isMethod_returnsFieldName() {
        String fieldName = LambdaUtils.getFieldName(TestEntity::isActive);
        Assertions.assertEquals("active", fieldName);
    }

    @Test
    void getFieldName_invalidMethod_throwsException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> LambdaUtils.getFieldName(TestEntity::invalidMethod));
    }

    @Getter
    public static class TestEntity {

        private String name;

        private boolean active;

        public String invalidMethod() {
            return "invalid";
        }
    }
}
