package com.Banking.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
    private Long transactionId;
    private Long accountId;  // ✅ Ensure this exists
    private BigDecimal amount;
    private String transactionType;
    private String transactionStatus;
    private LocalDateTime transactionDate;
}
