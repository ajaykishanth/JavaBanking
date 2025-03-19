package com.online.banking.response.dto;

import com.online.banking.entity.CardStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlockCardResponseDTO {
    private Long cardId;
    private String cardNumber;
    private CardStatus status;
}
