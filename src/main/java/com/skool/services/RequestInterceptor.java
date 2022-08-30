package com.skool.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {
    Logger log = LoggerFactory.getLogger(RequestInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object object) throws Exception {
        String requestURI = request.getRequestURI();
        log.info(requestURI);
        String tenantID = request.getHeader("X-TenantID");
        if (tenantID == null) {
            if(requestURI.equalsIgnoreCase("/createtenant")){
                TenantContext.setCurrentTenant("DEFAULT_TENANT_ID");
                return true;
            }
            response.getWriter().write("X-TenantID not present in the Request Header");
            response.setStatus(400);
            return false;
        }
        TenantContext.setCurrentTenant(tenantID);
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        log.error(request.getRequestURI());
        TenantContext.clear();
    }

}