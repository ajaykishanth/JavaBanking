package com.banking.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banking.dto.request.TransactionRequest;
import com.banking.dto.response.TransactionResponse;
import com.banking.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @Operation(summary = "Withdraw money from account")
    @PostMapping("/withdraw")
    public ResponseEntity<TransactionResponse> withdraw(@RequestBody TransactionRequest request) {
        return ResponseEntity.ok(transactionService.withdraw(request));
    }

    @Operation(summary = "Deposit money into account")
    @PostMapping("/deposit")
    public ResponseEntity<TransactionResponse> deposit(@RequestBody TransactionRequest request) {
        return ResponseEntity.ok(transactionService.deposit(request));
    }

    @Operation(summary = "Create a new transaction")
    @PostMapping("/create")
    public ResponseEntity<TransactionResponse> createTransaction(@RequestBody TransactionRequest request) {
        return ResponseEntity.ok(transactionService.createTransaction(request));
    }

    @Operation(summary = "Delete a transaction")
    @DeleteMapping("/transactions/{transactionId}")
    public ResponseEntity<String> deleteTransaction(@PathVariable Long transactionId) {
        String message = transactionService.deleteTransaction(transactionId);
        return ResponseEntity.ok(message);  // Return the success message
    }


    @Operation(summary = "Find all transactions")
    @GetMapping("/all")
    public ResponseEntity<List<TransactionResponse>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.findAllTransactions());
    }

    @Operation(summary = "Find transaction by ID")
    @GetMapping("/{transactionId}")
    public ResponseEntity<TransactionResponse> getTransactionById(@PathVariable Long transactionId) {
        return ResponseEntity.ok(transactionService.findTransactionById(transactionId));
    }

    @Operation(summary = "Activate an account")
    @PostMapping("/activateAccount/{accountId}")
    public ResponseEntity<String> activateAccount(@PathVariable Long accountId) {
        String message = transactionService.activateAccount(accountId);
        return ResponseEntity.ok(message);  // Return the success or error message
    }
}
