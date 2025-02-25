package com.myhaimi.sms.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "MARK", nullable = false)
    private int mark;
    @Column(name = "NAME", nullable = false)
    private String name;
    @NotNull(message = "Email cannot be null")
    @Column(name="EMAIL", nullable = false, unique = true)
    private String email;
}
