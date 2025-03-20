package com.Banking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private LocalDateTime dateOfBirth;
    private boolean isActive;
    private boolean isDeleted;
    private LocalDateTime registrationDate;
    private LocalDateTime lastUpdatedDate;
}
