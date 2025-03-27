package com.task.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.task.bank.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/Users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
 
        return userService.login(username, password);
    }
    @PostMapping("/register")
    public String register(@RequestParam String username, 
                           @RequestParam String password) {
        return userService.addUser(username, password);
    }
}
