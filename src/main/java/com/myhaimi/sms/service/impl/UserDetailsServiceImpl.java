package com.myhaimi.sms.service.impl;

import com.myhaimi.sms.DTO.UserDTO;
import com.myhaimi.sms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.myhaimi.sms.entity.Role;

@Component
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user=userService.findByUsername(username);
        if(user!=null){
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getRoles().stream()
                            .map(Role::getName)
                            .toArray(String[]::new))
                    .build();
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
