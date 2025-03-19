package com.Online.bankingapplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Online.bankingapplication.entity.Bank;

public interface BankRepository extends JpaRepository<Bank,String > {

	Optional<Bank> findByUserIdAndIsDeletedFalse(String userId);

	List<Bank> findByIsDeletedFalse();

	 
}