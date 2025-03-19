package com.Banking.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class AccountResponse {
    private Long accountId;
    private Long userId;
    private String accountType;
    private BigDecimal balance;
    private String status;
    private LocalDateTime createdDate;
}
