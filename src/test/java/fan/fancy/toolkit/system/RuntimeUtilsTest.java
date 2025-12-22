package fan.fancy.toolkit.system;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@link RuntimeUtils} 测试类.
 *
 * @author Fan
 */
class RuntimeUtilsTest {

    @Test
    void getAvailableProcessors_validEnvironment_returnsPositiveNumber() {
        int processors = RuntimeUtils.getAvailableProcessors();
        Assertions.assertTrue(processors > 0);
    }

    @Test
    void getAvailableProcessors_multipleCalls_returnsConsistentValue() {
        int processors1 = RuntimeUtils.getAvailableProcessors();
        int processors2 = RuntimeUtils.getAvailableProcessors();
        Assertions.assertEquals(processors1, processors2);
    }
}
