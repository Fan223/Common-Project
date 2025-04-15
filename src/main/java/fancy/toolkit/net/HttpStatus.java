package fancy.toolkit.net;

/**
 * HTTP 状态类.
 *
 * @author Fan
 * @since 2025/2/19 9:38
 */
public class HttpStatus {

    // 1xx, Informational.
    /**
     * 继续.
     */
    public static final int CONTINUE = 100;

    /**
     * 切换协议.
     */
    public static final int SWITCHING_PROTOCOLS = 101;

    // 2xx, Successful.
    /**
     * 请求成功
     */
    public static final int OK = 200;

    /**
     * 已创建.
     */
    public static final int CREATED = 201;

    /**
     * 已接受.
     */
    public static final int ACCEPTED = 202;

    /**
     * 非权威信息.
     */
    public static final int NON_AUTHORITATIVE_INFORMATION = 203;

    /**
     * 无内容.
     */
    public static final int NO_CONTENT = 204;

    /**
     * 重置内容.
     */
    public static final int RESET_CONTENT = 205;

    /**
     * 部分内容.
     */
    public static final int PARTIAL_CONTENT = 206;

    // 3xx, Redirection.
    /**
     * 多项选择.
     */
    public static final int MULTIPLE_CHOICES = 300;

    /**
     * 永久移动.
     */
    public static final int MOVED_PERMANENTLY = 301;

    /**
     * 临时移动. 目前还是以 FOUND 为首选项.
     */
    public static final int MOVED_TEMPORARILY = 302;

    /**
     * 已找到.
     */
    public static final int FOUND = 302;

    /**
     * 参见其他内容.
     */
    public static final int SEE_OTHER = 303;

    /**
     * 未修改.
     */
    public static final int NOT_MODIFIED = 304;

    /**
     * 使用代理.
     */
    public static final int USE_PROXY = 305;

    /**
     * 临时重定向.
     */
    public static final int TEMPORARY_REDIRECT = 307;

    // 4xx, Client error.
    /**
     * 错误请求.
     */
    public static final int BAD_REQUEST = 400;

    /**
     * 未授权.
     */
    public static final int UNAUTHORIZED = 401;

    /**
     * 需付款.
     */
    public static final int PAYMENT_REQUIRED = 402;

    /**
     * 禁止访问.
     */
    public static final int FORBIDDEN = 403;

    /**
     * 未找到.
     */
    public static final int NOT_FOUND = 404;

    /**
     * 方法不被允许.
     */
    public static final int METHOD_NOT_ALLOWED = 405;

    /**
     * 不可接受.
     */
    public static final int NOT_ACCEPTABLE = 406;

    /**
     * 需要代理身份验证.
     */
    public static final int PROXY_AUTHENTICATION_REQUIRED = 407;

    /**
     * 请求超时.
     */
    public static final int REQUEST_TIMEOUT = 408;

    /**
     * 冲突.
     */
    public static final int CONFLICT = 409;

    /**
     * 已删除.
     */
    public static final int GONE = 410;

    /**
     * 需要长度.
     */
    public static final int LENGTH_REQUIRED = 411;

    /**
     * 前提条件失败.
     */
    public static final int PRECONDITION_FAILED = 412;

    /**
     * 请求实体过大.
     */
    public static final int REQUEST_ENTITY_TOO_LARGE = 413;

    /**
     * 请求 URI 过长.
     */
    public static final int REQUEST_URI_TOO_LONG = 414;

    /**
     * 不支持的媒体类型.
     */
    public static final int UNSUPPORTED_MEDIA_TYPE = 415;

    /**
     * 请求范围不满足.
     */
    public static final int REQUESTED_RANGE_NOT_SATISFIABLE = 416;

    /**
     * 期望失败.
     */
    public static final int EXPECTATION_FAILED = 417;

    // 5xx, Server error.
    /**
     * 服务器内部错误.
     */
    public static final int INTERNAL_SERVER_ERROR = 500;

    /**
     * 未实现.
     */
    public static final int NOT_IMPLEMENTED = 501;

    /**
     * 错误网关.
     */
    public static final int BAD_GATEWAY = 502;

    /**
     * 服务不可用.
     */
    public static final int SERVICE_UNAVAILABLE = 503;

    /**
     * 网关超时.
     */
    public static final int GATEWAY_TIMEOUT = 504;

    /**
     * 不支持 HTTP 版本.
     */
    public static final int VERSION_NOT_SUPPORTED = 505;

    private HttpStatus() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }
}
