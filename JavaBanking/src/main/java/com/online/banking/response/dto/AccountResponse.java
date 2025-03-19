package com.online.banking.response.dto;


import com.online.banking.entity.Account;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
    private Long accountId;
    private String accountNumber;
    private String accountType;
    private String accountStatus;
    private BigDecimal balance;
    private Long userId;

    // Constructor to map entity to DTO
    public AccountResponse(Account account) {
        this.accountId = account.getAccountId();
        this.accountNumber = account.getAccountNumber();
        this.accountType = account.getAccountType();
        this.accountStatus = account.getAccountStatus();
        this.balance = account.getBalance();
        this.userId = account.getUser().getUserId();
    }
}
