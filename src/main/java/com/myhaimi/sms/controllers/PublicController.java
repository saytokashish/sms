package com.myhaimi.sms.controllers;

import com.myhaimi.sms.entity.User;
import com.myhaimi.sms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/public")
public class PublicController {

    @Autowired
    private IUserService userService;

    @GetMapping("/health-check")
    public String getHealth(){
        return "OK";
    }

    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser= userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
