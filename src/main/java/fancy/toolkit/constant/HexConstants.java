package fancy.toolkit.constant;

/**
 * 十六进制常量类.
 *
 * @author Fan
 * @since 2025/2/19 8:44
 */
public class HexConstants {

    /**
     * 二进制: {@code 00000000 11111111}, 十进制: {@code 255}.
     */
    public static final Integer FF = 0x000000FF;

    /**
     * 二进制: {@code 11111111 00000000}, 十进制: {@code 65280}.
     */
    public static final Integer FF00 = 0x0000FF00;

    /**
     * 二进制: {@code 11111111 11111111}, 十进制: {@code 65535}.
     */
    public static final Integer FFFF = 0x0000FFFF;

    private HexConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }
}
