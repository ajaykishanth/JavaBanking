package com.online.banking.request.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlockCardRequestDTO {
    @NotNull(message = "Card ID cannot be null")
    private Long cardId;
}

