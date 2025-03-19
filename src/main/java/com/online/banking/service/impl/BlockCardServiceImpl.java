package com.online.banking.service.impl;

import com.online.banking.entity.Card;
import com.online.banking.entity.CardStatus;
import com.online.banking.repository.CardRepository;
import com.online.banking.request.dto.BlockCardRequestDTO;
import com.online.banking.response.dto.BlockCardResponseDTO;
import com.online.banking.service.BlockCardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockCardServiceImpl implements BlockCardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public BlockCardResponseDTO blockCard(BlockCardRequestDTO request) {
    	 Card card = cardRepository.findById(request.getCardId()).orElse(null);
         if (card == null) {
             throw new RuntimeException("Card not found");
         }
        card.setStatus(CardStatus.Blocked);
        Card updatedCard = cardRepository.save(card);
        return mapToResponseDTO(updatedCard);
    }

    private BlockCardResponseDTO mapToResponseDTO(Card card) {
        BlockCardResponseDTO response = new BlockCardResponseDTO();
        response.setCardId(card.getCardId());
        response.setCardNumber(card.getCardNumber());
        response.setStatus(card.getStatus());
        return response;
    }
}
