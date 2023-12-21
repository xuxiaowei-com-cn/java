package cn.com.xuxiaowei.java.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

/**
 * 日志过滤器
 *
 * @author xuxiaowei
 */
@Slf4j
@Order(HIGHEST_PRECEDENCE)
@Component
public class LogHttpFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String requestUri = request.getRequestURI();
        log.info("requestUri: {}", requestUri);

        response.setHeader("Request-Uri", requestUri);

        // 匹配
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        boolean matchActuator = antPathMatcher.match("/actuator/**", requestUri);

        if (!matchActuator) {
            Enumeration<String> headerNames = request.getHeaderNames();
            log.info("打印 header 开始");
            while (headerNames.hasMoreElements()) {
                String key = headerNames.nextElement();
                Enumeration<String> values = request.getHeaders(key);
                log.info("{} : {}", key, Collections.list(values));
            }
            log.info("打印 header 结束");
        }

        String timeout = request.getParameter("timeout");
        if (timeout != null) {

            log.info("接收到延时 {}s", timeout);

            Integer integer = null;

            try {
                integer = Integer.parseInt(timeout);
            } catch (Exception e) {
                log.error("{} 转为转为 int 异常", timeout, e);
            }

            if (integer != null) {
                try {
                    log.info("开始延时");
                    Thread.sleep(integer * 1000L);
                    log.info("结束延时");
                } catch (InterruptedException e) {
                    log.error("延时 {}s 异常", integer, e);
                }
            }
        }

        super.doFilter(request, response, chain);
    }

}
