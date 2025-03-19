package com.online.banking.request.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssueCardRequestDTO {

    @NotNull(message = "Please enter a valid account ID")
    private Long accountId;
}
