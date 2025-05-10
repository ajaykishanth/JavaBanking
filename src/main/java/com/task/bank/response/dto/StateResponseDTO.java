package com.task.bank.response.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateResponseDTO {

	@NotNull(message="Id should not be empty or null")
	@Min(value=1,message="Id should be greated than 0")
	private Long stateId;
    private String stateName;
    private Integer countryId;
    private Boolean isActive;

  }
