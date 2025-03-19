package com.online.banking.response.dto;

import com.online.banking.entity.CardType;
import com.online.banking.entity.CardStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class IssueCardResponseDTO {
    private Long cardId;
    private Long accountId;
    private String cardNumber;
    private String pin;
    private CardType cardType;
    private CardStatus status;
    private BigDecimal limitAmount;
    private LocalDate expiryDate;
}

