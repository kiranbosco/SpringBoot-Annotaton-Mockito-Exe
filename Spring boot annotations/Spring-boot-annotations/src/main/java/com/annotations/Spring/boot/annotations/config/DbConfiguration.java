package com.annotations.Spring.boot.annotations.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DbConfiguration {

    @Value("${db.driverClass}")
    private String driverClass;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    @Bean
    @Profile("dev")
    public String datasourceProperties(){
        System.out.println(driverClass + " " + url + "" +username + "" +password);
        return "Data type connection is DEV type";
    }
}
