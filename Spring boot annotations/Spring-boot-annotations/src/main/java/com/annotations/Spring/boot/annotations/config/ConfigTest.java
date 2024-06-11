package com.annotations.Spring.boot.annotations.config;

import com.annotations.Spring.boot.annotations.beanConfig.BeanTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigTest {

    @Bean
    public BeanTest createBen(){
        return new BeanTest();
    }

}
