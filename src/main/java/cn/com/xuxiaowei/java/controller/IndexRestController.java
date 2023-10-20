package cn.com.xuxiaowei.java.controller;

import cn.com.xuxiaowei.java.common.net.HttpHeaders;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
public class IndexRestController {

    @RequestMapping("")
    public Map<String, Object> index(HttpServletRequest request, HttpServletResponse response) {
        String queryString = request.getQueryString();
        log.info("接收到参数：{}", queryString);

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> headerNamesMap = new HashMap<>();
        map.put("headerNames", headerNamesMap);

        String remoteHost = request.getRemoteHost();
        map.put("remoteHost", remoteHost);

        String remoteAddr = request.getRemoteAddr();
        map.put("remoteAddr", remoteAddr);

        int remotePort = request.getRemotePort();
        map.put("remotePort", remotePort);

        HttpHeaders.forwarded(request, map);
        HttpHeaders.xForwardedFor(request, map);
        HttpHeaders.xForwardedHost(request, map);
        HttpHeaders.xForwardedPort(request, map);
        HttpHeaders.xForwardedProto(request, map);
        HttpHeaders.xForwardedScheme(request, map);
        HttpHeaders.xOriginalForwardedFor(request, map);
        HttpHeaders.xRealIp(request, map);
        HttpHeaders.xRequestId(request, map);
        HttpHeaders.xScheme(request, map);

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            Enumeration<String> headers = request.getHeaders(headerName);

            headerNamesMap.put(headerName, Collections.list(headers));
        }

        return map;
    }

}
