package com.BankingApplication.Entity;

import jakarta.persistence.*;

@Entity
public class LoanEligibility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    private int id;

    @Column(nullable = false)  // Ensures loan_type cannot be null
    private String loanType;

    @Column(nullable = false)  // Ensures eligibility_criteria cannot be null
    private String eligibilityCriteria;

    // Default constructor
    public LoanEligibility() {}

    // Parameterized constructor
    public LoanEligibility(String loanType, String eligibilityCriteria) {
        this.loanType = loanType;
        this.eligibilityCriteria = eligibilityCriteria;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    // Override toString for easy printing
    @Override
    public String toString() {
        return "LoanEligibility{" +
                "id=" + id +
                ", loanType='" + loanType + '\'' +
                ", eligibilityCriteria='" + eligibilityCriteria + '\'' +
                '}';
    }
}
