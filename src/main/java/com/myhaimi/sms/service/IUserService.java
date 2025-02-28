package com.myhaimi.sms.service;


import com.myhaimi.sms.entity.User;

public interface IUserService {
    User createUser(User user);
    User findByUsername(String username);
    User getUserById(int id);
    User updateUser(User user, String username);
}
