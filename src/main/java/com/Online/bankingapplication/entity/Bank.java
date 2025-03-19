package com.Online.bankingapplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "user_table")
@Data

public class Bank {

    @Id
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

    @Column(nullable = true)
    @NotNull(message = "isActive field cannot be null")
    private Boolean isActive ;

    
    @Column(nullable = false)
    @NotNull(message = "isDeleted field cannot be null")
    private Boolean isDeleted;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate registrationDate = LocalDate.now();
    
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate lastUpdatedDate = LocalDate.now();
    
    
    
    @PrePersist
    protected void onCreate() {
        if (this.isActive == null) {
            this.isActive = true;
        }
        if (this.isDeleted == null) {
            this.isDeleted = false;
        }
        this.registrationDate = LocalDate.now();
        this.lastUpdatedDate = LocalDate.now();
    }
    
}