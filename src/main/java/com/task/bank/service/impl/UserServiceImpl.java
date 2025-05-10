package com.task.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.task.bank.entity.User;
import com.task.bank.repository.UserRepository;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return "User not found!";
        }

        // Check if account is locked
        if (isAccountLocked(user)) {
            return "Account is locked. Please try again after 24 hours.";
        }

        // Validate password
        if (passwordEncoder.matches(password, user.getPassword())) {
            // Reset failed attempts after successful login
            user.setFailedLoginAttempts(0);
            userRepository.save(user);
            return "Login successful!";
        } else {
            // Increment failed attempts
            user.setFailedLoginAttempts(user.getFailedLoginAttempts() + 1);

            // Lock the account if 3 failed attempts
            if (user.getFailedLoginAttempts() >= 3) {
                user.setLockoutTimestamp(LocalDateTime.now());
            }

            userRepository.save(user);
            return "Invalid credentials! Attempts: " + user.getFailedLoginAttempts();
        }
    }

    private boolean isAccountLocked(User user) {
        if (user.getLockoutTimestamp() == null) {
            return false;
        }

        Duration duration = Duration.between(user.getLockoutTimestamp(), LocalDateTime.now());
        if (duration.toHours() >= 24) {
            // Unlock the account after 24 hours
            user.setFailedLoginAttempts(0);
            user.setLockoutTimestamp(null);
            userRepository.save(user);
            return false;
        }

        return true;
    }
    
    public String addUser(String username, String password) {
        // Check if user already exists
        if (userRepository.findByUsername(username) != null) {
            return "Username is already taken!";
        }

        // Create a new user
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password)); // Encrypt password
        newUser.setFailedLoginAttempts(0); // Set initial failed attempts
        newUser.setLockoutTimestamp(null); // Ensure account is not locked initially

        // Save user to the database
        userRepository.save(newUser);
        return "User registered successfully!";
    }
    
}
