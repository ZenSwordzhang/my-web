package com.zsx.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AccessFilter extends ZuulFilter {

    private final static Logger LOGGER = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * pre：路由之前调用
     * route：路由时被调用
     * post：路由之后被调用
     * error：处理请求时发生错误时被调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 配置过滤的顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 配置是否需要过滤：true:需要，false:不需要
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        // 获取request
        HttpServletRequest request = requestContext.getRequest();

        LOGGER.info(String.format("%s AccessFilter request to %s", request.getMethod(), request.getRequestURL().toString()));
        String token = request.getHeader("token");

        if (StringUtils.isBlank(token)) {
            LOGGER.warn("Token is blank");
            // 过滤该请求，不进行路由
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            // 返回前端内容
            requestContext.setResponseBody("Token is blank");
            HttpServletResponse response = requestContext.getResponse();
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            requestContext.set("isSuccess", false);
            return null;
        }
        // 对该请求进行路由
        requestContext.setSendZuulResponse(true);
        requestContext.setResponseStatusCode(HttpStatus.OK.value());
        // 设置一个状态，下一个过滤器可能会用到的
        requestContext.set("isSuccess", true);
        LOGGER.info("OK");
        return null;

    }
}