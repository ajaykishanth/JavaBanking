package com.task.bank.controller;

import com.task.bank.request.dto.IssueAccountRequest;
import com.task.bank.response.dto.AccountResponse;
import com.task.bank.response.dto.UserResponse;

import com.task.bank.service.impl.UserService;
import com.task.bank.entity.Account;
import com.task.bank.entity.User;
import com.task.bank.service.impl.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
//id get user
    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
//search
    @GetMapping("/search")
    public Page<UserResponse> searchUsers(@RequestParam String query, @RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        return userService.searchUsers(query, pageNum, pageSize);
    }
//give account id
    @PostMapping("/{id}/issue-account")
    public AccountResponse issueAccount(@PathVariable Long id, @RequestBody IssueAccountRequest request) {
        return userService.issueAccountNumber(id, request);
    }
}
