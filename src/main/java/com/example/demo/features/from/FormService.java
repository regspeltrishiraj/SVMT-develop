package com.example.demo.features.from;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.security.Role;
import com.example.demo.security.RoleService;
import com.example.demo.security.User;
import com.example.demo.security.UserRepository;

@Service
public class FormService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired private BCryptPasswordEncoder encoder;

    public void registerForm(User user) {
        List<Role> roles = roleService.getRoles(); //Get all roles from roles table
        /* Finding Volunteer Role */
        Role role = roles.stream()
                .filter(r -> r.getDescription().equals("ROLE_USER"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Role not found"));

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        /* Adding role to user object */
        user.setRoles(roleSet);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
