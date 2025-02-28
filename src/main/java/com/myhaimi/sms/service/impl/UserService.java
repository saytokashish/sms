package com.myhaimi.sms.service.impl;

import com.myhaimi.sms.entity.User;
import com.myhaimi.sms.repository.UserRepo;
import com.myhaimi.sms.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private UserRepo userRepo;
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER"));
        return userRepo.save(user);
    }
    @Override
    public User findByUsername(String username){
        return userRepo.findByUsername(username).get(0);
    }
    @Override
    public User getUserById(int id){
        Optional<User> optionalUser= userRepo.findById(id);
        return optionalUser.get();
    }

    @Override
    public User updateUser(User user, String username) {
        User userInDb= findByUsername(username);
        userInDb.setUsername(user.getUsername());
        userInDb.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(userInDb);
    }

}
