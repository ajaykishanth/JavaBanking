package com.online.banking.service.impl;

import com.online.banking.entity.Card;
import com.online.banking.entity.CardStatus;
import com.online.banking.entity.CardType;
import com.online.banking.entity.UserAccount;
import com.online.banking.exception.AccountCardAlreadyExit;
import com.online.banking.exception.AccountInactiveException;
import com.online.banking.repository.CardRepository;
import com.online.banking.repository.UserAccountRepository;
import com.online.banking.response.dto.IssueCardResponseDTO;
import com.online.banking.service.IssueCardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

@Service
public class IssueCardServiceImpl implements IssueCardService {

    private static final Logger logger = LoggerFactory.getLogger(IssueCardServiceImpl.class);

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public IssueCardResponseDTO issueCard(Long accountId) {
        // Fetch the user account instance
        UserAccount userAccount = userAccountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found."));

        String accountStatus = userAccount.getAccountStatus();

        // Validate if the account is active
        if (!"ACTIVE".equalsIgnoreCase(accountStatus)) {
            logger.warn("Account {} is not active.", accountId);
            throw new AccountInactiveException("Card cannot be issued. Account is not active.");
        }

        // Check if the account already has a card
        Optional<Card> existingCard = cardRepository.findByAccountId(accountId);
        if (existingCard.isPresent()) {
            logger.warn("Account {} already has a card.", accountId);
            throw new AccountCardAlreadyExit("Account already has a card.");
        }

        // Generate PIN and hash it
        String plainPin = generateRandomPin();
        //String hashedPin = hashPin(plainPin);
        String hashedPin = plainPin;
        // Create new card object
        Card newCard = Card.builder()
                .accountId(accountId)
                .cardNumber(generateCardNumber())
                .cardType(CardType.DEBIT)
                .pin(hashedPin)
                .expiryDate(LocalDate.now().plusYears(3))
                .issueDate(LocalDate.now())
                .status(CardStatus.Issued)
                .limitAmount(BigDecimal.valueOf(50000))
                .build();

        // Save new card to DB
        Card savedCard = cardRepository.save(newCard);

        logger.info("Generated PIN for account {}: {}", accountId, plainPin);

        return mapToResponseDTO(savedCard);
    }

    private String generateCardNumber() {
        Random random = new Random();
        String cardNumber;
        do {
            StringBuilder cardNumberBuilder = new StringBuilder();
            for (int i = 0; i < 16; i++) {
                cardNumberBuilder.append(random.nextInt(10));
            }
            cardNumber = cardNumberBuilder.toString();
        } while (cardRepository.findByCardNumber(cardNumber).isPresent());
        return cardNumber;
    }

    private String generateRandomPin() {
        SecureRandom random = new SecureRandom();
        int pin = 1000 + random.nextInt(9000);
        return String.valueOf(pin);
    }

//    private String hashPin(String pin) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        return passwordEncoder.encode(pin);
//    }

    private IssueCardResponseDTO mapToResponseDTO(Card card) {
        IssueCardResponseDTO response = new IssueCardResponseDTO();
        response.setCardId(card.getCardId());
        response.setAccountId(card.getAccountId());
        response.setCardNumber(card.getCardNumber());
        response.setCardType(card.getCardType());
        response.setStatus(card.getStatus());
        response.setLimitAmount(card.getLimitAmount());
        response.setExpiryDate(card.getExpiryDate());
        return response;
    }
}
