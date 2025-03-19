package com.Banking.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountActivationRequest {

    @NotNull(message = "Account ID cannot be null")
    private Long accountId;
}
