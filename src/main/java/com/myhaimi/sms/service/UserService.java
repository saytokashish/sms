package com.myhaimi.sms.service;


import com.myhaimi.sms.entity.User;

public interface UserService {
    User createUser(User user);
    User findByUsername(String username);
}
