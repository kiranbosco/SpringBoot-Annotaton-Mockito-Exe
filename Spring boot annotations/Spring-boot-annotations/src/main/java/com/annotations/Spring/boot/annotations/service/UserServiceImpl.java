package com.annotations.Spring.boot.annotations.service;

import com.annotations.Spring.boot.annotations.beanConfig.BeanTest;
import com.annotations.Spring.boot.annotations.model.Users;
import com.annotations.Spring.boot.annotations.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserServiceImpl implements Userservice {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BeanTest beanTest;

    public Users createUsers(Users users){

        return this.userRepo.save(users);
    }

    public Iterable<Users> listOfusers(){
        beanTest.createBeanTest();
        return this.userRepo.findAll();
    }

    public Object checkNull(Object obj) {
        if ( obj != null ) {
            return obj;
        }
        return null;
    }



}


