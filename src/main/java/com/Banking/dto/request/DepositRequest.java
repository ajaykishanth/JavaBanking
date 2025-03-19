package com.Banking.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepositRequest {

    @NotNull(message = "Account ID cannot be null")
    private Long accountId;

    @NotNull(message = "Amount cannot be null")
    @Min(value = 1, message = "Amount must be greater than 0") // Ensures positive value
    private Double amount;

    @NotNull(message = "Transaction type cannot be null")
    private String transactionType;

    @NotNull(message = "Transaction status cannot be null")
    private String transactionStatus;
}
