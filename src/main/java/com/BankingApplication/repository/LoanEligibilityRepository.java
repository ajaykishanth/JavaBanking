package com.BankingApplication.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.BankingApplication.Entity.LoanEligibility;

@Repository
public interface LoanEligibilityRepository extends JpaRepository<LoanEligibility, Integer> {
    // You can add custom query methods here if needed
    // For example, to find by loan type:
    Optional<LoanEligibility> findByLoanType(String loanType);
}
