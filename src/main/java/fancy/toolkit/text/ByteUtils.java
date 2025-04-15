package fancy.toolkit.text;

/**
 * {@link Byte} 工具类.
 *
 * @author Fan
 * @since 2025/2/18 16:15
 */
public class ByteUtils {

    private ByteUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * 将字节数组转换为十六进制字符串.
     *
     * @param bytes 字节数组
     * @return {@link String}
     * @author Fan
     * @since 2025/2/18 16:16
     */
    public static String toHexString(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            // 格式化每个字节为两位十六进制字符串
            builder.append(String.format("%02X", bytes[i]));
            if (i < bytes.length - 1) {
                builder.append(":");
            }
        }
        return builder.toString();
    }
}
