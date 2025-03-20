package com.Banking.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionResponse {
    private Long transactionId;
    private Long accountId;  // This will be set from the associated UserAccount
    private String transactionType;
    private BigDecimal amount;
    private String transactionStatus;
}
