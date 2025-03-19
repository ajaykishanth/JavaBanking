package com.online.banking.service;

import com.online.banking.request.dto.ActivateCardRequestDTO;
import com.online.banking.response.dto.ActivateCardResponseDTO;

public interface ActivateCardService {
    ActivateCardResponseDTO activateCard(ActivateCardRequestDTO request);
}

