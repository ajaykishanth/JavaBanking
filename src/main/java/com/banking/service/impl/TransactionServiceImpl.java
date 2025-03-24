package com.banking.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banking.dto.request.TransactionRequest;
import com.banking.dto.response.TransactionResponse;
import com.banking.entity.Transaction;
import com.banking.entity.UserAccount;
import com.banking.exception.AccountNotFoundException;
import com.banking.exception.TransactionNotFoundException;
import com.banking.repository.TransactionRepository;
import com.banking.repository.UserAccountRepository;
import com.banking.service.TransactionService;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    private final UserAccountRepository userAccountRepository;
    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public TransactionResponse withdraw(@Valid TransactionRequest request) {
        // Log withdrawal initiation
        logger.info("Initiating withdrawal: accountId={}, amount={}", request.getAccountId(), request.getAmount());

        // Validate if account exists in the useraccount table
        UserAccount account = userAccountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));

        // Validate if the withdrawal amount is greater than zero and the account has enough balance
        if (request.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            logger.warn("Withdrawal amount must be greater than zero: {}", request.getAmount());
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero");
        }

        if (account.getBalance().compareTo(request.getAmount()) < 0) {
            logger.warn("Insufficient balance for withdrawal: accountId={}, availableBalance={}, withdrawalAmount={}",
                        request.getAccountId(), account.getBalance(), request.getAmount());
            throw new IllegalArgumentException("Insufficient balance for withdrawal");
        }
        
        if (request.getAmount().compareTo(new BigDecimal("10000")) > 0) {
            logger.warn("Maximum withdrawal limit exceeded: accountId={}, requestedAmount={}", request.getAccountId(), request.getAmount());
            throw new IllegalArgumentException("Maximum withdrawal limit exceeded");
        }

        // Update the balance of the account after withdrawal
        account.setBalance(account.getBalance().subtract(request.getAmount()));
        account.setUpdatedDate(LocalDateTime.now());
        userAccountRepository.save(account);

        // Log successful withdrawal
        logger.info("Withdrawal successful: accountId={}, amountWithdrawn={}", request.getAccountId(), request.getAmount());

        // Create and save the transaction
        return saveTransaction(request, "WITHDRAW", account);
    }

    @Override
    @Transactional
    public TransactionResponse deposit(@Valid TransactionRequest request) {
        // Log deposit initiation
        logger.info("Initiating deposit: accountId={}, amount={}", request.getAccountId(), request.getAmount());

        // Validate if account exists in the useraccount table
        UserAccount account = userAccountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));

        // Validate if the deposit amount is greater than zero
        if (request.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            logger.warn("Deposit amount must be greater than zero: {}", request.getAmount());
            throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }

        // Update the balance of the account after deposit
        account.setBalance(account.getBalance().add(request.getAmount()));
        account.setUpdatedDate(LocalDateTime.now());
        userAccountRepository.save(account);

        // Log successful deposit
        logger.info("Deposit successful: accountId={}, amountDeposited={}", request.getAccountId(), request.getAmount());

        // Create and save the transaction
        return saveTransaction(request, "DEPOSIT", account);
    }

    @Override
    @Transactional
    public TransactionResponse createTransaction(@Valid TransactionRequest request) {
        // Log transaction creation initiation
        logger.info("Creating transaction: accountId={}, transactionType={}, amount={}",
                    request.getAccountId(), request.getTransactionType(), request.getAmount());

        // Validate if account exists in the useraccount table
        UserAccount account = userAccountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));

        // Validate transaction type
        if (request.getTransactionType() == null || request.getTransactionType().isEmpty()) {
            logger.warn("Transaction type is required for accountId={}", request.getAccountId());
            throw new IllegalArgumentException("Transaction type is required");
        }

        // Create and save the transaction
        return saveTransaction(request, request.getTransactionType(), account);
    }

    private TransactionResponse saveTransaction(TransactionRequest request, String type, UserAccount account) {
        Transaction transaction = new Transaction();
        transaction.setUserAccount(account);
        transaction.setTransactionType(type);
        transaction.setAmount(request.getAmount());
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setTransactionStatus("SUCCESS");
        transaction.setCreatedDate(LocalDateTime.now());

        // Save the transaction to the database
        transactionRepository.save(transaction);

        // Log transaction saved
        logger.info("Transaction saved: accountId={}, transactionType={}, amount={}", 
                    account.getAccountId(), type, request.getAmount());

        // Return the transaction response using ModelMapper
        return modelMapper.map(transaction, TransactionResponse.class);
    }

    @Override
    public String deleteTransaction(Long transactionId) {
        // Log deletion initiation
        logger.info("Attempting to delete transaction with transactionId={}", transactionId);

        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> {
                    logger.error("Transaction not found for transactionId={}", transactionId);
                    return new TransactionNotFoundException("Transaction not found");
                });

        // Delete the transaction
        transactionRepository.delete(transaction);

        // Log successful deletion
        logger.info("Transaction deleted successfully: transactionId={}", transactionId);

        return "Transaction deleted successfully";
    }

    @Override
    public List<TransactionResponse> findAllTransactions() {
        // Log fetching all transactions
        logger.info("Fetching all transactions");

        return transactionRepository.findAll().stream()
                .map(transaction -> modelMapper.map(transaction, TransactionResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public TransactionResponse findTransactionById(Long transactionId) {
        // Log fetching transaction by ID
        logger.info("Fetching transaction by transactionId={}", transactionId);

        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found"));
        return modelMapper.map(transaction, TransactionResponse.class);
    }

    @Override
    public String activateAccount(Long accountId) {
        // Log account activation initiation
        logger.info("Attempting to activate account: accountId={}", accountId);

        // Fetch the account based on the provided account ID
        UserAccount account = userAccountRepository.findById(accountId)
                .orElseThrow(() -> {
                    logger.error("Account not found for accountId={}", accountId);
                    return new AccountNotFoundException("Account not found");
                });

        // Check if the account is already active
        if ("ACTIVE".equals(account.getAccountStatus())) {
            logger.info("Account is already active: accountId={}", accountId);
            return "Account is already active";  // Return a message if the account is already active
        }

        // Activate the account if it's not already active
        account.setAccountStatus("ACTIVE");
        account.setUpdatedDate(LocalDateTime.now());

        // Save the updated account details
        userAccountRepository.save(account);

        // Log successful account activation
        logger.info("Account activated successfully: accountId={}", accountId);

        return "Account activated successfully";  // Return a success message
    }
}
