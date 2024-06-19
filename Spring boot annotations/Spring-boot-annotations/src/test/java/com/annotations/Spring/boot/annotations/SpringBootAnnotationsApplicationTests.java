package com.annotations.Spring.boot.annotations;

import com.annotations.Spring.boot.annotations.repo.UserRepo;
import com.annotations.Spring.boot.annotations.service.Userservice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(classes = SpringBootAnnotationsApplicationTests.class)
@TestPropertySource("/insertData.sql")

class SpringBootAnnotationsApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private Userservice userservice;

	@Autowired
	private UserRepo userRepo;

	@BeforeEach
	public void testExecuteBefore(){

		jdbcTemplate.execute("insert into users(id, name,product)" + "values(1,'kiran','Asus')");

	}
	@Test
	void contextLoads() {
	}

	@Test
	public void test(){

	}

}
