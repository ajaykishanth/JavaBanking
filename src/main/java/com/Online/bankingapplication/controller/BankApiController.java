package com.Online.bankingapplication.controller;

import com.Online.bankingapplication.dto.request.BankRequest;
import com.Online.bankingapplication.dto.response.BankResponse;
import com.Online.bankingapplication.service.BankService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class BankApiController {

    private final BankService bankService; 

    @GetMapping("/{userId}")
    public BankResponse getBankDetails(@PathVariable String userId) {
        return bankService.getBank(userId); // Call method from BankService
    }

    @GetMapping
    public List<BankResponse> getAllBankDetails() {
        return bankService.getAllBanks();
    }

    @PostMapping
    public BankResponse createBankDetails(@Valid @RequestBody BankRequest bankRequest) {
        return bankService.createBank(bankRequest);
    }

    @PutMapping("/{userId}")
    public BankResponse updateBankDetails(@PathVariable String userId, @Valid @RequestBody BankRequest bankRequest) {
        return bankService.updateBank(userId, bankRequest);
    }

    @DeleteMapping("/{userId}")
    public String deleteBankDetails(@PathVariable String userId) {
        return bankService.deleteBank(userId);
    }
}
