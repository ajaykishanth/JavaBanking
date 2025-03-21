package com.online.banking.service.impl;

import com.online.banking.entity.Card;
import com.online.banking.entity.CardStatus;
import com.online.banking.entity.UserAccount;
import com.online.banking.exception.*;
import com.online.banking.repository.CardRepository;
import com.online.banking.repository.UserAccountRepository;
import com.online.banking.request.dto.ActivateCardRequestDTO;
import com.online.banking.response.dto.ActivateCardResponseDTO;
import com.online.banking.service.ActivateCardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

@Service
public class ActivateCardServiceImpl implements ActivateCardService {

    private static final Logger logger = LoggerFactory.getLogger(ActivateCardServiceImpl.class);

    private final CardRepository cardRepository;
    private final UserAccountRepository userAccountRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public ActivateCardServiceImpl(CardRepository cardRepository, UserAccountRepository userAccountRepository, BCryptPasswordEncoder passwordEncoder) {
        this.cardRepository = cardRepository;
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ActivateCardResponseDTO activateCard(ActivateCardRequestDTO request) {
        String cardNumber = request.getCardNumber();
        String pin = request.getPin();

        logger.info("Attempting to activate card with number: {}", cardNumber);

        // Validate input
        if (!StringUtils.hasText(cardNumber) || !StringUtils.hasText(pin)) {
            logger.warn("Card number or PIN is empty/null.");
            throw new IllegalArgumentException("Card number and PIN must be provided.");
        }

        // Fetch card by card number
        Card card = cardRepository.findByCardNumber(cardNumber).orElseThrow(
                () -> new CardNotFoundException("Card not found")
        );

        // Fetch associated user account
        UserAccount userAccount = userAccountRepository.findById(card.getAccountId()).orElseThrow(
                () -> new AccountNotFoundException("Associated account not found")
        );

        // Check account status
        if (!"ACTIVE".equalsIgnoreCase(userAccount.getAccountStatus())) {
            logger.warn("Account {} is not active, cannot activate card.", userAccount.getAccountId());
            throw new AccountInactiveException("Card activation failed. Account is not active.");
        }

        // Validate PIN using BCrypt
        if (!passwordEncoder.matches(pin, card.getPin())) {
            logger.warn("Incorrect PIN for card number: {}", cardNumber);
            throw new InvalidPinException("Incorrect PIN");
        }

        // Check if the card is expired
        if (card.getExpiryDate().isBefore(LocalDate.now())) {
            logger.warn("Card has expired: {}", cardNumber);
            throw new CardExpiredException("This card has expired and cannot be activated.");
        }

        // Check if the card is already active
        if (card.getStatus() == CardStatus.Active) {
            logger.warn("Card is already active: {}", cardNumber);
            throw new CardAlreadyActiveException("Card is already active");
        }

        // Activate the card
        card.setStatus(CardStatus.Active);
        try {
            Card updatedCard = cardRepository.save(card);
            logger.info("Card activated successfully: {}", updatedCard.getCardNumber());
            return mapToResponseDTO(updatedCard);
        } catch (Exception e) {
            logger.error("Error saving card: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to update card status.", e);
        }
    }

    private ActivateCardResponseDTO mapToResponseDTO(Card card) {
        ActivateCardResponseDTO response = new ActivateCardResponseDTO();
        response.setCardId(card.getCardId());
        response.setCardNumber(card.getCardNumber());
        response.setStatus(card.getStatus());
        return response;
    }
}
