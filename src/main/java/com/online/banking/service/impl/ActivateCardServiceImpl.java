package com.online.banking.service.impl;

import com.online.banking.entity.Card;
import com.online.banking.entity.CardStatus;
import com.online.banking.repository.CardRepository;
import com.online.banking.request.dto.ActivateCardRequestDTO;
import com.online.banking.response.dto.ActivateCardResponseDTO;
import com.online.banking.service.ActivateCardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivateCardServiceImpl implements ActivateCardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public ActivateCardResponseDTO activateCard(ActivateCardRequestDTO request) {
    	 Card card = cardRepository.findByCardNumber(request.getCardNumber()).orElse(null);
         if (card == null) {
             throw new RuntimeException("Card not found");
         }

        if (!card.getPin().equals(request.getPin())) {
            throw new RuntimeException("Incorrect PIN");
        }

        card.setStatus(CardStatus.Active);
        Card updatedCard = cardRepository.save(card);
        return mapToResponseDTO(updatedCard);
    }

    private ActivateCardResponseDTO mapToResponseDTO(Card card) {
        ActivateCardResponseDTO response = new ActivateCardResponseDTO();
        response.setCardId(card.getCardId());
        response.setCardNumber(card.getCardNumber());
        response.setStatus(card.getStatus());
        return response;
    }
}
