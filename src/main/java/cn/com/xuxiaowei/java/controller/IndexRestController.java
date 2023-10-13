package cn.com.xuxiaowei.java.controller;

import cn.com.xuxiaowei.java.common.net.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuxiaowei
 * @since 0.0.1
 */
@RestController
public class IndexRestController {

    @RequestMapping("")
    public Map<String, Object> index(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> headerNamesMap = new HashMap<>();
        map.put("headerNames", headerNamesMap);

        String remoteHost = request.getRemoteHost();
        map.put("remoteHost", remoteHost);

        String remoteAddr = request.getRemoteAddr();
        map.put("remoteAddr", remoteAddr);

        int remotePort = request.getRemotePort();
        map.put("remotePort", remotePort);

        map.put(HttpHeaders.FORWARDED, Collections.list(request.getHeaders(HttpHeaders.FORWARDED)));
        map.put(HttpHeaders.X_FORWARDED_FOR, Collections.list(request.getHeaders(HttpHeaders.X_FORWARDED_FOR)));
        map.put(HttpHeaders.X_FORWARDED_HOST, Collections.list(request.getHeaders(HttpHeaders.X_FORWARDED_HOST)));
        map.put(HttpHeaders.X_FORWARDED_PORT, Collections.list(request.getHeaders(HttpHeaders.X_FORWARDED_PORT)));
        map.put(HttpHeaders.X_FORWARDED_PROTO, Collections.list(request.getHeaders(HttpHeaders.X_FORWARDED_PROTO)));
        map.put(HttpHeaders.X_FORWARDED_SCHEME, Collections.list(request.getHeaders(HttpHeaders.X_FORWARDED_SCHEME)));
        map.put(HttpHeaders.X_ORIGINAL_FORWARDED_FOR, Collections.list(request.getHeaders(HttpHeaders.X_ORIGINAL_FORWARDED_FOR)));
        map.put(HttpHeaders.X_REAL_IP, Collections.list(request.getHeaders(HttpHeaders.X_REAL_IP)));
        map.put(HttpHeaders.X_REQUEST_ID, Collections.list(request.getHeaders(HttpHeaders.X_REQUEST_ID)));
        map.put(HttpHeaders.X_SCHEME, Collections.list(request.getHeaders(HttpHeaders.X_SCHEME)));

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            Enumeration<String> headers = request.getHeaders(headerName);

            headerNamesMap.put(headerName, Collections.list(headers));
        }

        return map;
    }

}
