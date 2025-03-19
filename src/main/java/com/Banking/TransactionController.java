package com.Banking;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Banking.dto.request.DepositRequest;
import com.Banking.dto.request.WithdrawRequest;
import com.Banking.dto.response.TransactionResponse;
import com.Banking.service.TransactionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
@Validated
public class TransactionController {

    private final TransactionService transactionService;
    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    /**
     * Deposit amount into an account
     */
    @PostMapping("/deposit")
    public ResponseEntity<TransactionResponse> deposit(@Valid @RequestBody DepositRequest request) {
        logger.info("Received deposit request for account: {}", request.getAccountId());
        return ResponseEntity.ok(transactionService.deposit(request));
    }


    /**
     * Withdraw amount from an account
     */
    @PostMapping("/withdraw")
    public ResponseEntity<TransactionResponse> withdraw(@Valid @RequestBody WithdrawRequest request) {
        logger.info("Received withdraw request for account: {}", request.getAccountId());
        return ResponseEntity.ok(transactionService.withdraw(request));
    }

    /**
     * Get a transaction by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponse> getTransactionById(@PathVariable Long id) {
        Optional<TransactionResponse> transaction = transactionService.getTransactionById(id);
        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Get all transactions
     */
    @GetMapping
    public ResponseEntity<List<TransactionResponse>> getAllTransactions() {
        logger.info("Fetching all transactions");
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    /**
     * Delete a transaction by ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable Long id) {
        logger.info("Deleting transaction with ID: {}", id);
        transactionService.deleteTransaction(id);
        return ResponseEntity.ok("Transaction deleted successfully");
    }
}
