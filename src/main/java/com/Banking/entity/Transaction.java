package com.Banking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private UserAccount userAccount;

    private String transactionType;
    private BigDecimal amount;
    private String transactionStatus;
    private LocalDateTime transactionDate;
    private LocalDateTime createdDate;
}
