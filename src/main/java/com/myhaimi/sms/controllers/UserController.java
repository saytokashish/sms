package com.myhaimi.sms.controllers;

import com.myhaimi.sms.entity.User;
import com.myhaimi.sms.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
       User savedUser= userService.createUser(user);
       return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
