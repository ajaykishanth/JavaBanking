package com.Banking.service;

import java.util.List;
import java.util.Optional;

import com.Banking.dto.request.DepositRequest;
import com.Banking.dto.request.WithdrawRequest;
import com.Banking.dto.response.TransactionResponse;

public interface TransactionService {
    TransactionResponse deposit(DepositRequest request);
    TransactionResponse withdraw(WithdrawRequest request);
    Optional<TransactionResponse> getTransactionById(Long transactionId);
    List<TransactionResponse> getAllTransactions();
    String deleteTransaction(Long transactionId);
    
}

