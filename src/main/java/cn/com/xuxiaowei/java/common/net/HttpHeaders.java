package cn.com.xuxiaowei.java.common.net;

/**
 * @author xuxiaowei
 * @since 0.0.1
 */
public class HttpHeaders {

    /**
     * The HTTP <a href="https://tools.ietf.org/html/rfc7239">{@code Forwarded}</a> header field name.
     */
    public static final String FORWARDED = "Forwarded";

    /**
     * The HTTP {@code X-Forwarded-For} header field name (superseded by {@code Forwarded}).
     */
    public static final String X_FORWARDED_FOR = "X-Forwarded-For";

    /**
     * The HTTP <a href="http://goo.gl/lQirAH">{@code X-Forwarded-Host}</a> header field name.
     */
    public static final String X_FORWARDED_HOST = "X-Forwarded-Host";

    /**
     * The HTTP <a href="http://goo.gl/YtV2at">{@code X-Forwarded-Port}</a> header field name.
     */
    public static final String X_FORWARDED_PORT = "X-Forwarded-Port";

    /**
     * The HTTP {@code X-Forwarded-Proto} header field name.
     */
    public static final String X_FORWARDED_PROTO = "X-Forwarded-Proto";

    public static final String X_FORWARDED_SCHEME = "X-Forwarded-Scheme";

    public static final String X_ORIGINAL_FORWARDED_FOR = "X-Original-Forwarded-For";

    public static final String X_REAL_IP = "X-Real-Ip";

    /**
     * The HTTP {@code X-Request-ID} header field name.
     */
    public static final String X_REQUEST_ID = "X-Request-ID";

    public static final String X_SCHEME = "X-Scheme";

}
