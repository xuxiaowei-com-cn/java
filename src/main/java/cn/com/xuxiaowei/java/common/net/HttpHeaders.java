package cn.com.xuxiaowei.java.common.net;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

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

    public static List<String> forwarded(HttpServletRequest request) {
        Enumeration<String> forwarded = request.getHeaders(FORWARDED);
        if (forwarded.hasMoreElements()) {
            return Collections.list(forwarded);
        }
        return null;
    }

    public static void forwarded(HttpServletRequest request, Map<String, Object> map) {
        Enumeration<String> forwarded = request.getHeaders(FORWARDED);
        if (forwarded.hasMoreElements()) {
            map.put(FORWARDED, Collections.list(forwarded));
        }
    }

    public static List<String> xForwardedFor(HttpServletRequest request) {
        Enumeration<String> xForwardedFor = request.getHeaders(X_FORWARDED_FOR);
        if (xForwardedFor.hasMoreElements()) {
            return Collections.list(xForwardedFor);
        }
        return null;
    }

    public static void xForwardedFor(HttpServletRequest request, Map<String, Object> map) {
        Enumeration<String> xForwardedFor = request.getHeaders(X_FORWARDED_FOR);
        if (xForwardedFor.hasMoreElements()) {
            map.put(X_FORWARDED_FOR, Collections.list(xForwardedFor));
        }
    }

    public static List<String> xForwardedHost(HttpServletRequest request) {
        Enumeration<String> xForwardedHost = request.getHeaders(X_FORWARDED_HOST);
        if (xForwardedHost.hasMoreElements()) {
            return Collections.list(xForwardedHost);
        }
        return null;
    }

    public static void xForwardedHost(HttpServletRequest request, Map<String, Object> map) {
        Enumeration<String> xForwardedHost = request.getHeaders(X_FORWARDED_HOST);
        if (xForwardedHost.hasMoreElements()) {
            map.put(X_FORWARDED_HOST, Collections.list(xForwardedHost));
        }
    }

    public static List<String> xForwardedPort(HttpServletRequest request) {
        Enumeration<String> xForwardedPort = request.getHeaders(X_FORWARDED_PORT);
        if (xForwardedPort.hasMoreElements()) {
            return Collections.list(xForwardedPort);
        }
        return null;
    }

    public static void xForwardedPort(HttpServletRequest request, Map<String, Object> map) {
        Enumeration<String> xForwardedPort = request.getHeaders(X_FORWARDED_PORT);
        if (xForwardedPort.hasMoreElements()) {
            map.put(X_FORWARDED_PORT, Collections.list(xForwardedPort));
        }
    }

    public static List<String> xForwardedProto(HttpServletRequest request) {
        Enumeration<String> xForwardedProto = request.getHeaders(X_FORWARDED_PROTO);
        if (xForwardedProto.hasMoreElements()) {
            return Collections.list(xForwardedProto);
        }
        return null;
    }

    public static void xForwardedProto(HttpServletRequest request, Map<String, Object> map) {
        Enumeration<String> xForwardedProto = request.getHeaders(X_FORWARDED_PROTO);
        if (xForwardedProto.hasMoreElements()) {
            map.put(X_FORWARDED_PROTO, Collections.list(xForwardedProto));
        }
    }

    public static List<String> xForwardedScheme(HttpServletRequest request) {
        Enumeration<String> xForwardedScheme = request.getHeaders(X_FORWARDED_SCHEME);
        if (xForwardedScheme.hasMoreElements()) {
            return Collections.list(xForwardedScheme);
        }
        return null;
    }

    public static void xForwardedScheme(HttpServletRequest request, Map<String, Object> map) {
        Enumeration<String> xForwardedScheme = request.getHeaders(X_FORWARDED_SCHEME);
        if (xForwardedScheme.hasMoreElements()) {
            map.put(X_FORWARDED_SCHEME, Collections.list(xForwardedScheme));
        }
    }

    public static List<String> xOriginalForwardedFor(HttpServletRequest request) {
        Enumeration<String> xOriginalForwardedFor = request.getHeaders(X_ORIGINAL_FORWARDED_FOR);
        if (xOriginalForwardedFor.hasMoreElements()) {
            return Collections.list(xOriginalForwardedFor);
        }
        return null;
    }

    public static void xOriginalForwardedFor(HttpServletRequest request, Map<String, Object> map) {
        Enumeration<String> xOriginalForwardedFor = request.getHeaders(X_ORIGINAL_FORWARDED_FOR);
        if (xOriginalForwardedFor.hasMoreElements()) {
            map.put(X_ORIGINAL_FORWARDED_FOR, Collections.list(xOriginalForwardedFor));
        }
    }

    public static List<String> xRealIp(HttpServletRequest request) {
        Enumeration<String> xRealIp = request.getHeaders(X_REAL_IP);
        if (xRealIp.hasMoreElements()) {
            return Collections.list(xRealIp);
        }
        return null;
    }

    public static void xRealIp(HttpServletRequest request, Map<String, Object> map) {
        Enumeration<String> xRealIp = request.getHeaders(X_REAL_IP);
        if (xRealIp.hasMoreElements()) {
            map.put(X_REAL_IP, Collections.list(xRealIp));
        }
    }

    public static List<String> xRequestId(HttpServletRequest request) {
        Enumeration<String> xRequestId = request.getHeaders(X_REQUEST_ID);
        if (xRequestId.hasMoreElements()) {
            return Collections.list(xRequestId);
        }
        return null;
    }

    public static void xRequestId(HttpServletRequest request, Map<String, Object> map) {
        Enumeration<String> xRequestId = request.getHeaders(X_REQUEST_ID);
        if (xRequestId.hasMoreElements()) {
            map.put(X_REQUEST_ID, Collections.list(xRequestId));
        }
    }


    public static List<String> xScheme(HttpServletRequest request) {
        Enumeration<String> xScheme = request.getHeaders(X_SCHEME);
        if (xScheme.hasMoreElements()) {
            return Collections.list(xScheme);
        }
        return null;
    }

    public static void xScheme(HttpServletRequest request, Map<String, Object> map) {
        Enumeration<String> xScheme = request.getHeaders(X_SCHEME);
        if (xScheme.hasMoreElements()) {
            map.put(X_SCHEME, Collections.list(xScheme));
        }
    }

}
