package com.online.banking.service;

import com.online.banking.response.dto.BlockCardResponseDTO;

public interface BlockCardService {
    BlockCardResponseDTO blockCard(Long cardId);
}


