package com.annotations.Spring.boot.annotations.service;

import com.annotations.Spring.boot.annotations.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Users> usersFiltering() {
        return null;
    }
}
