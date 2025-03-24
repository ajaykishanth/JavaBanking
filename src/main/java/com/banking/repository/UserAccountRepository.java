package com.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.entity.UserAccount;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByAccountNumber(String accountNumber);
}
