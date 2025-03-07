package com.myhaimi.sms.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username", nullable = false , unique = true)
    private String username;
    private String password;
    @Column(nullable = false, unique = true)
    private String email;
    private List<String> roles;
}
