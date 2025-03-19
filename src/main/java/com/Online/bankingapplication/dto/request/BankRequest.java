package com.Online.bankingapplication.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class BankRequest {

    @NotBlank(message = "User ID cannot be blank")
    private String userId;

    private String accountHolderName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    @NotBlank(message = "Phone number cannot be blank")
    private String phoneNumber;

    private String address;
    
    private String dateOfBirth;

    @NotNull(message = "isActive field cannot be null")
    private Boolean isActive;

    @NotNull(message = "isDeleted field cannot be null")
    private Boolean isDeleted;
}