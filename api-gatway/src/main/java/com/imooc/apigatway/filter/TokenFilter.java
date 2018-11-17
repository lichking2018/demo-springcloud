package com.imooc.apigatway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @ProjectName: api-gatway
 * @Package: com.imooc.apigatway.filter
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/12 5:23 PM
 * @Version: v1.0
 */
@Component
public class TokenFilter extends ZuulFilter{
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

//        这里从url参数中获取，也可以从cookie和head中获取
        String token = request.getParameter("token");
        if(StringUtils.isEmpty(token)){
////            不通过
//            requestContext.setSendZuulResponse(false);
//            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}
