package com.Online.bankingapplication.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class BankRequest {
    
    @NotNull(message = "User ID cannot be null")
    @Pattern(regexp = "^[0-9]+$", message = "User ID must contain only numbers")
    private String userId;

    @NotNull(message = "Accound holder name shouldn't be null")
    private String accountHolderName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    @NotBlank(message = "Phone number cannot be blank")
    private String phoneNumber;

    @NotBlank(message = "Address cannot be blank")
    @Size(min = 5, message = "Address must be at least 5 characters long")
    private String address;
    
    //private String address;
    
    @NotBlank(message = "Date of birth cannot be blank")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date of birth must be in format YYYY-MM-DD")
    private String dateOfBirth;
    
    //private String dateOfBirth;

    @NotNull(message = "isActive field cannot be null")
    private Boolean isActive;

    @NotNull(message = "isDeleted field cannot be null")
    private Boolean isDeleted;
}