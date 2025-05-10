package com.BankingApplication.controller;

import com.BankingApplication.response.dto.LoanEligibilityResponseDTO;
import com.BankingApplication.service.LoanEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/loan-eligibility")
public class LoanEligibilityController {

    @Autowired
    private LoanEligibilityService loanEligibilityService;

    // Endpoint to get all loan eligibility records
    @GetMapping("/")
    public ResponseEntity<List<LoanEligibilityResponseDTO>> getAllLoanEligibility() {
        List<LoanEligibilityResponseDTO> loanEligibilityList = loanEligibilityService.getAllLoanEligibility();
        return new ResponseEntity<>(loanEligibilityList, HttpStatus.OK);
    }

    // Endpoint to get loan eligibility by loan type
    @GetMapping("/type/{loanType}")
    public LoanEligibilityResponseDTO getLoanEligibilityByLoanType(@PathVariable String loanType) {
       LoanEligibilityResponseDTO loanEligibilityOptional = loanEligibilityService.getLoanEligibilityByLoanType(loanType);

       return loanEligibilityOptional;
    }

    
    
    
    
    
}