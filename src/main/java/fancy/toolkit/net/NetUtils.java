package fancy.toolkit.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 网络工具类.
 *
 * @author Fan
 * @since 2025/2/18 10:10
 */
public class NetUtils {

    private NetUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * 获取本地主机.
     *
     * @return {@link InetAddress}
     * @author Fan
     * @since 2025/2/18 10:52
     */
    public static InetAddress getLocalHost() {
        try {
            return InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new NetException(e);
        }
    }

    /**
     * 获取本地主机 IP 地址.
     *
     * @return {@link String}
     * @author Fan
     * @since 2025/2/18 10:52
     */
    public static String getLocalHostAddress() {
        return getLocalHost().getHostAddress();
    }

    /**
     * 获取本地主机硬件地址.
     *
     * @return {@code byte[]}
     * @author Fan
     * @since 2025/2/18 16:05
     */
    public static byte[] getLocalHardwareAddress() {
        return getHardwareAddress(getLocalHost());
    }

    /**
     * 获取指定网络地址的硬件地址.
     *
     * @param addr {@link InetAddress}
     * @return {@code byte[]}
     * @author Fan
     * @since 2025/2/18 16:06
     */
    public static byte[] getHardwareAddress(InetAddress addr) {
        try {
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(addr);
            return null == networkInterface ? null : networkInterface.getHardwareAddress();
        } catch (SocketException e) {
            throw new NetException("Failed to get hardware address for address: " + addr.getHostAddress(), e);
        }
    }
}
