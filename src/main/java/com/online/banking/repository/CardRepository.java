
package com.online.banking.repository;

import com.online.banking.entity.Card;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
	
	boolean existsByAccountId(Long accountId); 
	
	Optional<Card> findByCardNumber(String cardNumber);

}
