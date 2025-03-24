package com.banking.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.banking.enums.TransactionType;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

@Data
public class TransactionRequest {

    @NotNull(message = "Account ID is required")
    private Long accountId;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be positive")
    private BigDecimal amount;

    @NotEmpty(message = "Transaction type is required")
    private String transactionType;

    // Getter and Setter
    public void setTransactionType(String transactionType) {
        if (!TransactionType.isValid(transactionType)) {
            throw new IllegalArgumentException("Invalid transaction type");
        }
        this.transactionType = transactionType;
    }

    // Getters and Setters
}
