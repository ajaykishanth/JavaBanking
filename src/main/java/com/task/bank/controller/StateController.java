package com.task.bank.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.task.bank.response.dto.StateResponseDTO;
import com.task.bank.service.impl.StateServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/state")
@AllArgsConstructor
public class StateController {
	
	
	
	private final StateServiceImpl stateService;


	@GetMapping("/country/{id}")
    @Operation(summary="byCountry  ",
	description="Method to get list of States by Country",
	responses= {
			@ApiResponse(responseCode="200",description="Succesone"),
			@ApiResponse(responseCode="400",description="Bad Operation"),
	}
)
	public ResponseEntity<List<StateResponseDTO>>  getStateList(@Valid @PathVariable("id") Long countryId){
		List<StateResponseDTO> stateList = stateService.getStateListByCountryId(countryId);
		return stateList.isEmpty()
				?ResponseEntity.notFound().build()
						:ResponseEntity.ok(stateList);
	}
}
