/*
package com.annotations.Spring.boot.annotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails userDetails = User.withUsername("kiran")
                .password(encoder.encode("purini"))
                .roles("admin")
                .build();
        UserDetails userDetails1 = User.withUsername("manoja")
                .password(encoder.encode("purini2"))
                .roles("admin")
                .build();
                return new InMemoryUserDetailsManager(userDetails1, userDetails);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      return   http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/bank-api/all").permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/bank-api/**").authenticated()
                .and()
                .formLogin()
                .and()
                .build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
*/
