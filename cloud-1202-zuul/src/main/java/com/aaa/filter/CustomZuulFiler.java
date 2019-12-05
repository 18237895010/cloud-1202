package com.aaa.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CustomZuulFiler extends ZuulFilter {
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
        return true
                ;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext=RequestContext.getCurrentContext();
        HttpServletRequest request=currentContext.getRequest();
        String token=request.getParameter("token");
        System.out.println("token====="+token);
        if(null!=token){
            currentContext.setSendZuulResponse(true);
            currentContext.setResponseStatusCode(200);
            currentContext.set("isSuccess",true);
        }else {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            try{
                currentContext.getResponse().getWriter().write("token null");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
