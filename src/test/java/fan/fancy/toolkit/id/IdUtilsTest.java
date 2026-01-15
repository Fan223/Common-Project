package fan.fancy.toolkit.id;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@link IdUtils} 测试类.
 *
 * @author Fan
 */
class IdUtilsTest {

    @Test
    void generateSnowflakeId_multipleCalls_returnsDifferentIds() {
        long id1 = IdUtils.generateSnowflakeId();
        long id2 = IdUtils.generateSnowflakeId();

        Assertions.assertTrue(id1 > 0);
        Assertions.assertTrue(id2 > 0);
        Assertions.assertNotEquals(id1, id2);
    }

    @Test
    void generateSnowflakeIdStr_singleCall_returnsValidString() {
        String id = IdUtils.generateSnowflakeIdStr();

        Assertions.assertNotNull(id);
        Assertions.assertInstanceOf(String.class, id);
        Assertions.assertTrue(id.matches("\\d+"));
    }

    @Test
    void generateUuid_multipleCalls_returnsDifferentUuids() {
        String uuid1 = IdUtils.generateUuid();
        String uuid2 = IdUtils.generateUuid();

        Assertions.assertNotNull(uuid1);
        Assertions.assertNotNull(uuid2);
        Assertions.assertEquals(36, uuid1.length());
        Assertions.assertNotEquals(uuid1, uuid2);
    }

    @Test
    void generateDataCenterId_withMaxValue_returnsValidId() {
        long maxDataCenterId = 31L;
        long dataCenterId = IdUtils.generateDataCenterId(maxDataCenterId);

        Assertions.assertTrue(dataCenterId >= 0);
        Assertions.assertTrue(dataCenterId <= maxDataCenterId);
    }

    @Test
    void generateDataCenterId_multipleCalls_returnsSameId() {
        long maxDataCenterId = 31L;
        long id1 = IdUtils.generateDataCenterId(maxDataCenterId);
        long id2 = IdUtils.generateDataCenterId(maxDataCenterId);

        Assertions.assertEquals(id1, id2);
    }

    @Test
    void generateWorkerId_withValidParams_returnsValidId() {
        long dataCenterId = 1L;
        long maxWorkerId = 31L;
        long workerId = IdUtils.generateWorkerId(dataCenterId, maxWorkerId);

        Assertions.assertTrue(workerId >= 0);
        Assertions.assertTrue(workerId <= maxWorkerId);
    }

    @Test
    void generateWorkerId_sameParams_returnsSameId() {
        long dataCenterId = 1L;
        long maxWorkerId = 31L;
        long id1 = IdUtils.generateWorkerId(dataCenterId, maxWorkerId);
        long id2 = IdUtils.generateWorkerId(dataCenterId, maxWorkerId);

        Assertions.assertEquals(id1, id2);
    }

    @Test
    void generateWorkerId_differentDataCenterId_mayReturnDifferentId() {
        long maxWorkerId = 31L;
        long id1 = IdUtils.generateWorkerId(0L, maxWorkerId);
        long id2 = IdUtils.generateWorkerId(1L, maxWorkerId);

        Assertions.assertTrue(id1 >= 0 && id1 <= maxWorkerId);
        Assertions.assertTrue(id2 >= 0 && id2 <= maxWorkerId);
    }
}
