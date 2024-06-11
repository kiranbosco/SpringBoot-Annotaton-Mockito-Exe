package com.annotations.Spring.boot.annotations.intercepter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class GeneralInterceptor implements HandlerInterceptor {

    private Logger  LOG = LoggerFactory.getLogger(GeneralInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.info("preHandler method invoked...{}:{}"+request.getRequestURI(),request.getMethod());
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    LOG.info("postHandler method invoked...{}:{}"+request.getRequestURI(),request.getMethod());
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    if(ex!=null){
            LOG.error("Exception inside afterCompletion " +ex.getMessage());
    }
    LOG.info("afterCompletion method invoked...{}:{}" +request.getRequestURI(),request.getMethod());
    }
}
