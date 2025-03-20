package com.Online.bankingapplication.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;  
import org.springframework.stereotype.Service;

import com.Online.bankingapplication.dto.request.BankRequest;
import com.Online.bankingapplication.dto.response.BankResponse;
import com.Online.bankingapplication.entity.Bank;
import com.Online.bankingapplication.repository.BankRepository;
import com.Online.bankingapplication.service.BankService;

import lombok.AllArgsConstructor; 

@Service
@AllArgsConstructor
public class BankServiceImpl implements BankService {  

    private final BankRepository bankRepository;
    private final ModelMapper modelMapper;
    private static final Logger logger = LoggerFactory.getLogger(BankServiceImpl.class);

    @Override
    public BankResponse createBank(BankRequest bankRequest) {
    	
    	
    	 Optional<Bank> existingBank = bankRepository.findById(bankRequest.getUserId());
    	    
    	    if (existingBank.isPresent() && !existingBank.get().getIsDeleted()) {
    	        logger.warn("User with userId {} already exists", bankRequest.getUserId());
    	        throw new RuntimeException("User with ID " + bankRequest.getUserId() + " already exists.");
    	    }
    	
    	
        Bank bank = modelMapper.map(bankRequest, Bank.class);
        bank.setIsActive(bankRequest.getIsActive() != null ? bankRequest.getIsActive() : true);
        bank.setIsDeleted(bankRequest.getIsDeleted() != null ? bankRequest.getIsDeleted() : false);
        bank.setRegistrationDate(LocalDate.now());
        bank.setLastUpdatedDate(LocalDate.now());
        bankRepository.save(bank);
        logger.info("Bank account created for userId: {}", bank.getUserId());
        return modelMapper.map(bank, BankResponse.class);
    }

    @Override
    public BankResponse updateBank(String userId, BankRequest bankRequest) {
        Optional<Bank> optionalBank = bankRepository.findById(userId);
        if (optionalBank.isPresent()) {
            Bank bank = optionalBank.get();
            modelMapper.map(bankRequest, bank);
            bank.setLastUpdatedDate(LocalDate.now());
            bankRepository.save(bank);
            logger.info("Bank account updated for userId: {}", userId);
            return modelMapper.map(bank, BankResponse.class);
        } else {
            logger.error("Bank record not found for userId: {}", userId);
            throw new RuntimeException("Bank record not found for userId: " + userId);
        }
    }

    @Override
    public String deleteBank(String userId) {
        Optional<Bank> optionalBank = bankRepository.findById(userId);
        if (optionalBank.isPresent()) {
            Bank bank = optionalBank.get();
            bank.setIsDeleted(true);
            bankRepository.save(bank);
            logger.info("Bank account soft deleted for userId: {}", userId);
            return "Bank details soft deleted successfully";
        } else {
            logger.error("Bank record not found for userId: {}", userId);
            return "Error: Bank record not found for userId: " + userId;
        }
    }

    @Override
    public BankResponse getBank(String userId) {
        Bank bank = bankRepository.findByUserIdAndIsDeletedFalse(userId)
                .orElseThrow(() -> new RuntimeException("Bank user not found or deleted"));
        return modelMapper.map(bank, BankResponse.class);
    }

    @Override
    public List<BankResponse> getAllBanks() {
        return bankRepository.findByIsDeletedFalse().stream()
                .map(bank -> modelMapper.map(bank, BankResponse.class))
                .collect(Collectors.toList());
    }
}
