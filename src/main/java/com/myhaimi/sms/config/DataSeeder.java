package com.myhaimi.sms.config;

import com.myhaimi.sms.entity.Role;
import com.myhaimi.sms.entity.User;
import com.myhaimi.sms.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.myhaimi.sms.repository.RoleRepo;

import java.util.*;

@Component
public class DataSeeder implements CommandLineRunner {
    private final RoleRepo roleRepository;
    private final UserRepo userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(RoleRepo roleRepository, UserRepo userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // List of roles
        List<String> roleNames = Arrays.asList(
                "Admin", "Principal", "Teacher", "Student", "Parent", "Receptionist",
                "Librarian", "Accountant", "IT Support", "Transport Manager",
                "Counselor", "Exam Coordinator", "Hostel Warden", "Super Admin"
        );

        // Insert roles if they don’t exist
        for (String roleName : roleNames) {
            Role r=new Role();
            r.setName(roleName);
            List<Role> er= roleRepository.findByName(roleName);
            if(er.isEmpty())
                roleRepository.save(r);
        }

        // Create Super Admin user if not exists
        if (userRepository.findByUsername("Kashish").isEmpty()) {
            List<Role> superAdminRole = roleRepository.findByName("Super Admin");
            Set<Role> roles = new HashSet<>();
            if(!superAdminRole.isEmpty())
                roles.add(superAdminRole.getFirst());

            User u=new User();
            u.setEmail("arorakashish957@gmail.com");
            u.setUsername("Kashish");
            u.setPassword(passwordEncoder.encode("abc"));
            u.setRoles(roles);

            userRepository.save(u);
            System.out.println("Super Admin user seeded!");
        }
    }
}


