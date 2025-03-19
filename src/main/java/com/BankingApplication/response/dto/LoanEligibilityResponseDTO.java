package com.BankingApplication.response.dto;

public class LoanEligibilityResponseDTO {

    private String loanType;
    private String eligibilityCriteria;

    // Default constructor
    public LoanEligibilityResponseDTO() {}

    // Constructor with parameters
    public LoanEligibilityResponseDTO(String loanType, String eligibilityCriteria) {
        this.loanType = loanType;
        this.eligibilityCriteria = eligibilityCriteria;
    }

      public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getEligibilityCriteria() {
        return eligibilityCriteria;
    }

    public void setEligibilityCriteria(String eligibilityCriteria) {
        this.eligibilityCriteria = eligibilityCriteria;
    }

    // Override toString for easier debugging
    @Override
    public String toString() {
        return "LoanEligibilityResponseDTO{" +
                ", loanType='" + loanType + '\'' +
                ", eligibilityCriteria='" + eligibilityCriteria + '\'' +
                '}';
    }
}

