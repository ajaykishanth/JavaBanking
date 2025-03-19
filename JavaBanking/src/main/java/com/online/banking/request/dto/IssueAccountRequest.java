package com.online.banking.request.dto;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IssueAccountRequest {
    private String accountType;
    private BigDecimal initialDeposit;  
    }
