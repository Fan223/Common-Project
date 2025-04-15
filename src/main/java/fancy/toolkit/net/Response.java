package fancy.toolkit.net;

/**
 * 统一响应类.
 *
 * @author Fan
 * @since 2025/2/17 6:21
 */
public record Response<T>(int code, String message, T data) {

    public static <T> Response<T> builder(int code, String message, T data) {
        return new Response<>(code, message, data);
    }

    public static <T> Response<T> success() {
        return success(null);
    }

    public static <T> Response<T> success(T data) {
        return success("success", data);
    }

    public static <T> Response<T> success(String message, T data) {
        return builder(200, message, data);
    }

    public static <T> Response<T> fail() {
        return fail(null);
    }

    public static <T> Response<T> fail(T data) {
        return fail("failure", data);
    }

    public static <T> Response<T> fail(String message, T data) {
        return builder(500, message, data);
    }
}
