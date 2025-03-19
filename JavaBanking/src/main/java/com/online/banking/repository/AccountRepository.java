package com.online.banking.repository;

import com.online.banking.entity.Account;
import com.online.banking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByUser(User user);

	boolean existsByAccountNumber(String accountNumber);
}
