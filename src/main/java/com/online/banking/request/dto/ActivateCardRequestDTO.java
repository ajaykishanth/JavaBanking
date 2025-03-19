package com.online.banking.request.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActivateCardRequestDTO {
    @NotNull(message = "Card number cannot be null")
    private String cardNumber;
    
    @NotNull(message = "PIN cannot be null")
    private String pin;
}
