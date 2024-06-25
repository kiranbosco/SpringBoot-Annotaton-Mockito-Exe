package com.annotations.Spring.boot.annotations.service;

import com.annotations.Spring.boot.annotations.model.Users;

import java.util.List;

public interface Userservice {

    public Users createUsers(Users users);
    public Iterable<Users> listOfusers();

}
