package com.online.banking.service.impl;

import com.online.banking.entity.Card;
import com.online.banking.entity.CardStatus;
import com.online.banking.entity.CardType;
import com.online.banking.repository.CardRepository;
import com.online.banking.request.dto.IssueCardRequestDTO;
import com.online.banking.response.dto.IssueCardResponseDTO;
import com.online.banking.service.IssueCardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Random;

@Service
public class IssueCardServiceImpl implements IssueCardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public IssueCardResponseDTO issueCard(IssueCardRequestDTO request) {
        Card newCard = Card.builder()
                .accountId(request.getAccountId())
                .cardNumber(generateCardNumber())
                .cardType(CardType.DEBIT)
                .pin(generateRandomPin())
                .expiryDate(LocalDate.now().plusYears(3))
                .issueDate(LocalDate.now())
                .status(CardStatus.Issued)
                .limitAmount(BigDecimal.valueOf(50000))
                .build();

        Card savedCard = cardRepository.save(newCard);
        return mapToResponseDTO(savedCard);
    }

    private String generateCardNumber() {
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            cardNumber.append(random.nextInt(10));
        }
        return cardNumber.toString();
    }

    private String generateRandomPin() {
        SecureRandom random = new SecureRandom();
        int pin = 1000 + random.nextInt(9000);
        return String.valueOf(pin);
    }

    private IssueCardResponseDTO mapToResponseDTO(Card card) {
        IssueCardResponseDTO response = new IssueCardResponseDTO();
        response.setCardId(card.getCardId());
        response.setAccountId(card.getAccountId());
        response.setCardNumber(card.getCardNumber());
        response.setPin(card.getPin());
        response.setCardType(card.getCardType());
        response.setStatus(card.getStatus());
        response.setLimitAmount(card.getLimitAmount());
        response.setExpiryDate(card.getExpiryDate());
        return response;
    }
}
