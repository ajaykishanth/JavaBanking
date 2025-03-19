package com.Banking.service;

import com.Banking.dto.request.DepositRequest;
import com.Banking.dto.request.WithdrawRequest;
import com.Banking.dto.response.TransactionResponse;
import com.Banking.entity.Account;
import com.Banking.entity.Transaction;
import com.Banking.exception.InsufficientBalanceException;
import com.Banking.exception.ResourceNotFoundException;
import com.Banking.repository.accountRepository;
import com.Banking.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final accountRepository accountRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public TransactionResponse deposit(DepositRequest request) {
        // Fetch account entity
        Account account = accountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + request.getAccountId()));

        // Convert request amount to BigDecimal (if it's coming as a double)
        BigDecimal depositAmount = BigDecimal.valueOf(request.getAmount().doubleValue());  // ✅ Fix

        // Update account balance
        account.setBalance(account.getBalance().add(depositAmount));  // ✅ Fix
        accountRepository.save(account);

        // Create transaction entry
        Transaction transaction = Transaction.builder()
                .account(account)
                .amount(depositAmount)  // ✅ Fix
                .transactionType("DEPOSIT")
                .transactionStatus("SUCCESS")
                .transactionDate(LocalDateTime.now())
                .build();

        transactionRepository.save(transaction);

        return modelMapper.map(transaction, TransactionResponse.class);
    }



    @Override
    @Transactional
    public TransactionResponse withdraw(WithdrawRequest request) {
        Account account = accountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + request.getAccountId()));

        BigDecimal currentBalance = account.getBalance();
        
        if (currentBalance.compareTo(request.getAmount()) < 0) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal.");
        }

        // Deduct amount from account balance
        account.setBalance(currentBalance.subtract(request.getAmount()));
        accountRepository.save(account); // ✅ Ensure balance is updated in the database

        // Create transaction record
        Transaction transaction = Transaction.builder()
                .account(account) // ✅ Now this works!
                .amount(request.getAmount().negate())
                .transactionType("WITHDRAW")
                .transactionStatus("SUCCESS")
                .transactionDate(LocalDateTime.now())
                .build();
        
        transactionRepository.save(transaction); // ✅ Ensure transaction is saved in the database

        return modelMapper.map(transaction, TransactionResponse.class);
    }



    @Override
    public Optional<TransactionResponse> getTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId)
                .map(transaction -> modelMapper.map(transaction, TransactionResponse.class));
    }

    @Override
    public List<TransactionResponse> getAllTransactions() {
        return transactionRepository.findAll().stream()
                .map(transaction -> modelMapper.map(transaction, TransactionResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public String deleteTransaction(Long transactionId) {
        transactionRepository.deleteById(transactionId);
        return "Transaction deleted successfully";
    }
}
