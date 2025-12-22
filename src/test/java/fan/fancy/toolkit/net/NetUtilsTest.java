package fan.fancy.toolkit.net;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;

/**
 * {@link NetUtils} 测试类.
 *
 * @author Fan
 */
class NetUtilsTest {

    @Test
    void getLocalHost_validEnvironment_returnsInetAddress() {
        InetAddress localHost = NetUtils.getLocalHost();
        Assertions.assertNotNull(localHost);
    }

    @Test
    void getLocalHostAddress_validEnvironment_returnsIpAddress() {
        String hostAddress = NetUtils.getLocalHostAddress();
        Assertions.assertNotNull(hostAddress);
        Assertions.assertFalse(hostAddress.isEmpty());
    }

    @Test
    void getLocalHardwareAddress_validEnvironment_returnsByteArray() {
        byte[] hardwareAddress = NetUtils.getLocalHardwareAddress();

        // MAC 地址可能为 null(虚拟网卡等情况)
        if (hardwareAddress != null) {
            Assertions.assertTrue(hardwareAddress.length > 0);
        }
    }

    @Test
    void getHardwareAddress_withLocalHost_returnsMacAddress() {
        InetAddress localHost = NetUtils.getLocalHost();
        byte[] hardwareAddress = NetUtils.getHardwareAddress(localHost);

        // MAC 地址可能为 null
        if (hardwareAddress != null) {
            Assertions.assertTrue(hardwareAddress.length > 0);
        }
    }

    @Test
    void getHardwareAddressString_withLocalHost_returnsHexString() {
        InetAddress localHost = NetUtils.getLocalHost();
        String addressString = NetUtils.getHardwareAddressString(localHost);

        // MAC 地址字符串可能为 null
        if (addressString != null) {
            Assertions.assertFalse(addressString.isEmpty());
            System.out.println(addressString);
            // MAC 地址格式通常为 12 个十六进制字符(不含分隔符)
            Assertions.assertTrue(addressString.matches("[0-9A-Fa-f:]+"));
        }
    }
}
