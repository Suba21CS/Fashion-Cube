package com.example.fashion.controller;

import com.example.fashion.model.User;
import com.example.fashion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    // Register new user
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // Login
    @PostMapping("/login")
    public User login(@RequestBody User loginRequest) {
        return userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
    }

    // Get all users
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
