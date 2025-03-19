package com.Online.bankingapplication.dto.response;

import lombok.Data;

@Data
public class BankResponse {
    private String userId;
    private String accountHolderName;
    private String email;
    private String phoneNumber;
    private String address;
    private String dateOfBirth;
    private Boolean isActive;
    private Boolean isDeleted;
    private String registrationDate;
    private String lastUpdatedDate;
}