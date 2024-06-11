package com.purinis.BankingTransaction.config;

import com.purinis.BankingTransaction.utils.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigTest {

    @Bean
    public TestBean createTestBean(){
        return new TestBean();
    }

}
