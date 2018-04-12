package org.spring.cloud.gateway.login.fliter;

/**
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

 * @author  allen
 * filterType: 过滤器类型，决定过滤器在请求的生命周期中执行位置。
 * filterOrder:过滤器的执行顺序。当请求在一个阶段中存在多个过滤器的时候，需要根据该方法的返回值来执行
 * shouldFilter:判断该过滤器是否需要被执行。实际中根据该方法，设置过滤器的作用范围
 * run: 过滤器的具体逻辑。


@Component
public class AccessTokenFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String access_token = request.getParameter("access_token");
        if (StringUtils.isBlank(access_token)) {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            System.out.println("access deny!!!");
            return null;
        }
        System.out.println("access is ok!");
        return null;
    }
}

 */
