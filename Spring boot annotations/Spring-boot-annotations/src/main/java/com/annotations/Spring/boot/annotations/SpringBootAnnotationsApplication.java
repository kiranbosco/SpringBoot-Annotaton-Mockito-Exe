package com.annotations.Spring.boot.annotations;

import com.annotations.Spring.boot.annotations.model.UserAuth;
import com.annotations.Spring.boot.annotations.model.Users;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class SpringBootAnnotationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAnnotationsApplication.class, args);

	}
	@Bean
	@Scope(value = "prototype")
	Users getUserInfo() {
		return new Users();
	}
	@Bean
	@Scope(value = "prototype")
	UserAuth getUserAUth() {
		return new UserAuth();
	}
}
