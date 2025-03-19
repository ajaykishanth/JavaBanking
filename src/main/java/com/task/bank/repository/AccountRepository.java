package com.task.bank.repository;

import com.task.bank.entity.Account;
import com.task.bank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByUser(User user);

	boolean existsByAccountNumber(String accountNumber);
}
