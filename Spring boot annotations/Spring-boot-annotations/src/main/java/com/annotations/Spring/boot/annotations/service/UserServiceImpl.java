package com.annotations.Spring.boot.annotations.service;

import com.annotations.Spring.boot.annotations.beanConfig.BeanTest;
import com.annotations.Spring.boot.annotations.model.Users;
import com.annotations.Spring.boot.annotations.repo.UserRepo;
import jakarta.annotation.PostConstruct;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
@Primary
public class UserServiceImpl implements Userservice {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BeanTest beanTest;

    @Autowired
    private SampleComponent sampleComponent;

    public Users createUsers(Users users){

        return this.userRepo.save(users);
    }

    public Iterable<Users> listOfusers(){
        beanTest.createBeanTest();
        sampleComponent.sampe();
        return this.userRepo.findAll();
    }

    public Object checkNull(Object obj) {
        if ( obj != null ) {
            return obj;
        }
        return null;
    }



}


