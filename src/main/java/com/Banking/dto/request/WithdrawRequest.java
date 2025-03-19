package com.Banking.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class WithdrawRequest {

    @NotNull(message = "Account ID is required")
    private Long accountId;

    @Positive(message = "Withdraw amount must be greater than zero")
    private BigDecimal amount;

    @NotBlank(message = "Transaction type is required")
    private String transactionType;

    private String transactionStatus;
}
