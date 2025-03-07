package com.myhaimi.sms.controllers;

import com.myhaimi.sms.DTO.UserDTO;
import com.myhaimi.sms.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private IUserService userService;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserDTO user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName= authentication.getName();
        userService.updateUser(user, userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
