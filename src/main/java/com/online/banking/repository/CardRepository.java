
package com.online.banking.repository;

import com.online.banking.entity.Card;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
	
	boolean existsByAccountId(Long accountId); 
	boolean existsByCardNumber(String cardNumber);
	   @Query("SELECT c FROM Card c WHERE LOWER(c.cardNumber) = LOWER(:cardNumber)")
	    Optional<Card> findByCardNumber(@Param("cardNumber") String cardNumber);
	   Optional<Card> findByAccountId(Long accountId);
	   

}
