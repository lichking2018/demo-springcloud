package com.imooc.apigatway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

import java.util.UUID;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_RESPONSE_FILTER_ORDER;

/**
 * @ProjectName: api-gatway
 * @Package: com.imooc.apigatway.filter
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/12 5:59 PM
 * @Version: v1.0
 */
@Component
public class AddResponseHeaderFilter extends ZuulFilter{
    @Override
//    指定 filter的类型为后处理
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return SEND_RESPONSE_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();

        HttpServletResponse response = currentContext.getResponse();

        response.setHeader("X-Foo", UUID.randomUUID().toString());
        return null;
    }
}
