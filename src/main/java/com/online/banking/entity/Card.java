package com.online.banking.entity;
import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -9135924846527852198L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long cardId;

    @Column(name = "account_id", nullable = false)
    
    private Long accountId; 

    @Column(name = "card_number", unique = true, length = 16, nullable = false)
    private String cardNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_type", nullable = false)
    private CardType cardType; // Debit or Credit

    @Column(name = "pin", length = 4, nullable = false)
    private String pin; // 4-digit PIN

    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiryDate;

    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CardStatus status; // Active, Blocked,issuse

    @Column(name = "limit_amount", nullable = false)
    private BigDecimal limitAmount;
}

