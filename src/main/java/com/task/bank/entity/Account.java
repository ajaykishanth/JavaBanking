package com.task.bank.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @NotBlank
    @Size(max = 20)
    @Column(name = "account_number", nullable = false, unique = true, length = 20)
    private String accountNumber;

    @NotBlank
    @Size(max = 50)
    @Column(name = "account_type", nullable = false, length = 50)
    private String accountType;

    @NotBlank
    @Pattern(regexp = "ACTIVE|INACTIVE|CLOSED", message = "Status must be ACTIVE, INACTIVE, or CLOSED")
    @Column(name = "account_status", nullable = false, length = 20)
    private String accountStatus;

    @DecimalMin(value = "0.00")
    @Column(name = "balance", nullable = false, precision = 10, scale = 2)
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(name = "updated_date", nullable = false)
    private LocalDateTime updatedDate = LocalDateTime.now();
}
