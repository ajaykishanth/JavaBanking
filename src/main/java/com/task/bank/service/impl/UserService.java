package com.task.bank.service.impl;

import com.task.bank.request.dto.IssueAccountRequest;
import com.task.bank.response.dto.AccountResponse;
import com.task.bank.response.dto.UserResponse;
import com.task.bank.entity.Account;
import com.task.bank.entity.User;
import com.task.bank.repository.AccountRepository;
import com.task.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    //Get User by ID
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserResponse(user);
    }

    //Search Users for phonenumber ande name
    public Page<UserResponse> searchUsers(String query, int pageNum, int pageSize) {
        return userRepository.findByFirstNameContainingOrLastNameContainingOrPhoneNumberContainingOrEmailContaining(
                query, query, query, query, PageRequest.of(pageNum, pageSize))
                .map(UserResponse::new);
    }

    //Issue an Account with a Unique Account Number
    public AccountResponse issueAccountNumber(Long userId, IssueAccountRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (accountRepository.existsByUser(user)) {
            throw new RuntimeException("User already has an account!");
        }

        //Ensure the initial deposit is set
        BigDecimal initialDeposit = (request.getInitialDeposit() != null) ? request.getInitialDeposit() : BigDecimal.ZERO;

        //Generate a unique account number
        String accountNumber;
        do {
            accountNumber = "ACC" + (160000 + new Random().nextInt(8750000));
        } while (accountRepository.existsByAccountNumber(accountNumber)); 

        Account account = new Account();
        account.setUser(user);
        account.setAccountNumber(accountNumber); 
        account.setAccountType(request.getAccountType());
        account.setAccountStatus("ACTIVE");
        account.setBalance(initialDeposit);

        account = accountRepository.save(account);

        return new AccountResponse(account);
    }
}
