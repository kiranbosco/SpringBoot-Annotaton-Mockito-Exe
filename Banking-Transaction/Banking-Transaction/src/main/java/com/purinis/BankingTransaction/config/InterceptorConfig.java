package com.purinis.BankingTransaction.config;

import com.purinis.BankingTransaction.interceptor.GeneralInteceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private GeneralInteceptor generalInteceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(generalInteceptor);

    }
}
