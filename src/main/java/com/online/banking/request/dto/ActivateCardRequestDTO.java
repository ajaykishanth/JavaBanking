package com.online.banking.request.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString; // Add ToString

@Getter
@Setter
@ToString // Add ToString
public class ActivateCardRequestDTO {
    @NotNull(message = "Card number cannot be null")
    private String cardNumber;

    @NotNull(message = "PIN cannot be null")
    private String pin;
}

