package com.annotations.Spring.boot.annotations.service;

import com.annotations.Spring.boot.annotations.model.Users;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
//@Primary
public class UsersV2 implements  Userservice{
    @Override
    public Users createUsers(Users users) {
        return null;
    }

    @Override
    public Iterable<Users> listOfusers() {
        return null;
    }
}
