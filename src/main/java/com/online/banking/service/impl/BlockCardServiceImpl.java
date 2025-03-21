package com.online.banking.service.impl;

import com.online.banking.entity.Card;
import com.online.banking.entity.CardStatus;
import com.online.banking.exception.CardAlreadyBlockedException;
import com.online.banking.exception.CardExpiredException;
import com.online.banking.repository.CardRepository;
import com.online.banking.response.dto.BlockCardResponseDTO;
import com.online.banking.service.BlockCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BlockCardServiceImpl implements BlockCardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public BlockCardResponseDTO blockCard(Long cardId) {
       
       Optional<Card> optionalCard = cardRepository.findById(cardId);
        if (!optionalCard.isPresent()) {
            throw new RuntimeException("Card not found");
        }
        Card card = optionalCard.get();

        //  card is already blocked
        if (card.getStatus() == CardStatus.Blocked) {
            throw new CardAlreadyBlockedException("Card with ID " + cardId + " is already blocked.");
        }
        
        // card id expired
        if (card.getExpiryDate().isBefore(LocalDate.now())) {
          
            throw new CardExpiredException("This card has expired");
        }
        card.setStatus(CardStatus.Blocked);
        Card updatedCard = cardRepository.save(card);
        return mapToResponseDTO(updatedCard);
    }

    private BlockCardResponseDTO mapToResponseDTO(Card card) {
        BlockCardResponseDTO response = new BlockCardResponseDTO();
        response.setCardId(card.getCardId());
        return response;
    }
}
