package com.Banking.service;

import com.Banking.dto.request.TransactionRequest;
import com.Banking.dto.response.TransactionResponse;
import java.util.List;

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
