package com.Banking.repository;

import com.Banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface accountRepository extends JpaRepository<Account, Long> {
}
