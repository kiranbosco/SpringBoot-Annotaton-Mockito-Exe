package com.annotations.Spring.boot.annotations.config;

import com.annotations.Spring.boot.annotations.intercepter.GeneralInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    GeneralInterceptor generalInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(generalInterceptor);
    }
}
