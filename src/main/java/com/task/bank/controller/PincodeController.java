package com.task.bank.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.task.bank.response.dto.PincodeResponseDTO;
import com.task.bank.service.impl.PincodeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/pincode")
@AllArgsConstructor
public class PincodeController {
	
	private final PincodeServiceImpl pincodeService;

	@GetMapping("/city/{id}")
    @Operation(summary="By City  ",
	description="Method to get list of Pincode by City",
	responses= {
			@ApiResponse(responseCode="200",description="Succesone"),
			@ApiResponse(responseCode="400",description="Bad Operation"),
	}
)
	public ResponseEntity<?> getPincode(@Valid @PathVariable("id") Long cityId){
		
		List<PincodeResponseDTO> pincode =pincodeService.getPincodeByCityId(cityId);
		return pincode.isEmpty()?ResponseEntity.ok().body("No data"): ResponseEntity.ok(pincode);
	}
	
	
	

}
