package com.banking.service;

import java.util.List;

import com.banking.dto.request.TransactionRequest;
import com.banking.dto.response.TransactionResponse;

public interface TransactionService {
    
    // Method to withdraw money from an account
    TransactionResponse withdraw(TransactionRequest request);

    // Method to deposit money into an account
    TransactionResponse deposit(TransactionRequest request);

    // Method to create a transaction (for general transaction types like transfer, etc.)
    TransactionResponse createTransaction(TransactionRequest request);

    // Method to delete a transaction based on its ID
    String deleteTransaction(Long transactionId);

    // Method to fetch all transactions
    List<TransactionResponse> findAllTransactions();

    // Method to fetch a transaction by its ID
    TransactionResponse findTransactionById(Long transactionId);

    // Method to activate an account by its ID
    String activateAccount(Long accountId);

}
