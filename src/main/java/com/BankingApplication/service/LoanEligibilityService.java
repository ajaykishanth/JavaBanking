package com.BankingApplication.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankingApplication.Entity.LoanEligibility;
import com.BankingApplication.repository.LoanEligibilityRepository;
import com.BankingApplication.response.dto.LoanEligibilityResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanEligibilityService {
	
	@Autowired
    private ModelMapper modelMapper;  // Inject ModelMapper
	
    @Autowired
    private LoanEligibilityRepository loanEligibilityRepository;

    // Method to get all loan eligibility records as DTOs
    public List<LoanEligibilityResponseDTO> getAllLoanEligibility() {
        List<LoanEligibility> loanEligibilities = loanEligibilityRepository.findAll();
        return loanEligibilities.stream()
                .map(loan -> new LoanEligibilityResponseDTO(
                        loan.getLoanType(), 
                        loan.getEligibilityCriteria()))
                .collect(Collectors.toList());
    }

    // Method to get loan eligibility by ID
    public LoanEligibilityResponseDTO getLoanEligibilityByLoanType(String loanType) {
        return loanEligibilityRepository.findByLoanType(loanType)
        		 .map(loan -> modelMapper.map(loan, LoanEligibilityResponseDTO.class))  // Mapping entity to DTO
                 .orElse(null);  // Or throw exception if not found
    }
}
