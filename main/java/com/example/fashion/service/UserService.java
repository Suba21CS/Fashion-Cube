package com.example.fashion.service;

import com.example.fashion.model.User;
import com.example.fashion.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already registered.");
        }
        // In production: hash the password
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        User existingUser = userRepository.findByEmail(email);
        if (existingUser == null) {
            throw new RuntimeException("User not found.");
        }
        if (!existingUser.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password.");
        }
        return existingUser;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
