package com.online.banking.service;

import com.online.banking.request.dto.BlockCardRequestDTO;
import com.online.banking.response.dto.BlockCardResponseDTO;

public interface BlockCardService {
    BlockCardResponseDTO blockCard(BlockCardRequestDTO request);
}

