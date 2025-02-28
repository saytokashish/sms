package com.myhaimi.sms.repository;

import com.myhaimi.sms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    List<User> findByUsername(@Param("username") String username);
}
