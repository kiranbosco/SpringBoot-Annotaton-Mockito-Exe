package com.purinis.BankingTransaction.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class GeneralInteceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(GeneralInteceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("preHandle invoked...{}..{}" + request.getRequestURI(),request.getMethod());
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        logger.info("postHandle invoked...{}..{}" + request.getRequestURI(),request.getMethod());

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        if(ex!=null){
            logger.error("exception inside after Completions " + ex.getMessage());
        }
        logger.info("afterCompletion invoked...{}..{}" + request.getRequestURI(),request.getMethod());

    }
}
