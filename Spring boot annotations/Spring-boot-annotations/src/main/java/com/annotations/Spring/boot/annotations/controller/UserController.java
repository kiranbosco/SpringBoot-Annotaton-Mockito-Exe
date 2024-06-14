package com.annotations.Spring.boot.annotations.controller;
import com.annotations.Spring.boot.annotations.config.ConfigTest;
import com.annotations.Spring.boot.annotations.config.MailProps;
import com.annotations.Spring.boot.annotations.model.Users;
import com.annotations.Spring.boot.annotations.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Value("${mail.from}")
    private String from;
    @Value("${mail.host}")
    private String host;
    @Value("${mail.port}")
    private String port;

    @Autowired
    private MailProps mailProps;
    @Autowired
    //  @Qualifier("userServiceImpl")
    private Userservice userService;

    @Autowired
    private ConfigTest configTest;


    @PostMapping("/create")
    public ResponseEntity<Users> createUsers(@RequestBody Users users){
        Users user =    this.userService.createUsers(users);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @GetMapping(value = "/all")
    public List<Users> findAllCustomers() {
        System.out.println("Mail props in " +  mailProps);
        return (List<Users>) this.userService.listOfusers();
    }

}
