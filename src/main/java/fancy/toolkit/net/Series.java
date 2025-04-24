package fancy.toolkit.net;

/**
 * HTTP 状态系列.
 *
 * @author Fan
 * @since 2025/4/23 16:46
 */
public enum Series {

    INFORMATIONAL(1),

    SUCCESSFUL(2),

    REDIRECTION(3),

    CLIENT_ERROR(4),

    SERVER_ERROR(5);

    private final int value;

    Series(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
