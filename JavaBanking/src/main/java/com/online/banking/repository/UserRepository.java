package com.online.banking.repository;

import com.online.banking.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findByFirstNameContainingOrLastNameContainingOrPhoneNumberContainingOrEmailContaining(
        String firstName, String lastName, String phoneNumber, String email, Pageable pageable);
}
