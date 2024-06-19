package com.annotations.Spring.boot.annotations;

import com.annotations.Spring.boot.annotations.model.Users;
import com.annotations.Spring.boot.annotations.repo.UserRepo;
import com.annotations.Spring.boot.annotations.service.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = SpringBootAnnotationsApplication.class)
@TestPropertySource("/application.properties")

class SpringBootAnnotationsApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	Users users;
	@Autowired
	private UserRepo userRepo;

	@Mock
	private UserServiceImpl userservice;

	@Value("${sql.script.create.users}")
	private String  createUsers;

	@Value("${sql.script.delete.users}")
	private String deleteUser;

	@BeforeEach
	public void  beforeEachtestCaseExecuted(){
		//	jdbcTemplate.execute("insert into Users(id,name,product)"+"vlaue(1,'Eric', 'Samsung')");
		jdbcTemplate.execute(createUsers);
	}
	@Test
	public void testcheckServiceIsNullOrNot(){
		when(userservice.checkNull(users.getName())).thenReturn(true);
		assertNotNull(userservice.checkNull(users.getName()));
		verify(userservice,times(1)).checkNull(users.getName());
	}
	@Test
	public void testCreateUsers(){
		Users users1 = new Users(1,"kiran","samsung");

		when(userservice.createUsers(users1)).thenReturn(users);
		assertEquals(users,userservice.createUsers(users1));
		verify(userservice,times(1)).createUsers(users1);
	}
	@Test
	public void testGetAllUserInfo(){
		//initialization service
		List<Users> usersList = new ArrayList<>();
		usersList.add(new Users(1,"kiran","samsung"));
		when(userservice.listOfusers()).thenReturn(usersList);
		assertEquals(usersList,userservice.listOfusers());
		verify(userservice,times(1)).listOfusers();

	}

	@AfterEach
	public void afterEachTest(){
		jdbcTemplate.execute(deleteUser);
	}


}
