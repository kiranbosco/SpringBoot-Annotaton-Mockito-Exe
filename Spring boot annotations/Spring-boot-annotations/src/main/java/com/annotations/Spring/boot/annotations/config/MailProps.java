package com.annotations.Spring.boot.annotations.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "mail")
@Component
public class MailProps {

    private String from;
    private String host;
    private String port;

    public MailProps(){

    }
    public MailProps(String from, String host, String port) {
        this.from = from;
        this.host = host;
        this.port = port;
    }



}


