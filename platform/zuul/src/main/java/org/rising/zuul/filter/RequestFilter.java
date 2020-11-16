package org.rising.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: xue nian
 * @DateTime: 2020/11/13 11:25
 * @Description:
 */
@Component
public class RequestFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJ0b2tlbktleSI6InRva2VuS2V5IiwiaXNzIjoidHJhbnNmYXIiLCJ1c2VyTmFtZSI6ImRhZ2wiLCJleHAiOjE2MDUzMzcxNTgsInVzZXJJZCI6bnVsbCwiaWF0IjoxNjA1MjUwNzU4fQ.y3FH3V-dgKXyNjTG3uOd3o3zM0hpVPrudtfex4xgjH61NWoaxL9daBrP17uPGnrYlOPegY4ROv415N8go4Dv3w");
        ctx.addZuulRequestHeader("routePrivacy","gateway");
        return null;
    }
}
