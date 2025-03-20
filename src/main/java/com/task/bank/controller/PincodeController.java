package com.task.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.bank.response.dto.PincodeResponseDTO;
import com.task.bank.service.PincodeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/pincode")
public class PincodeController {
	
	private final PincodeService pincodeService;
	
	@Autowired
	public PincodeController(PincodeService pincodeService) {
		this.pincodeService =pincodeService;
	}
	
	@GetMapping("/by-city")
    @Operation(summary="By City  ",
	description="Method to get list of Pincode by City",
	responses= {
			@ApiResponse(responseCode="200",description="Succesone"),
			@ApiResponse(responseCode="400",description="Bad Operation"),
	}
)
	public ResponseEntity<?> getPincode(@RequestParam String cityName){
		
		if(cityName== null || cityName.isEmpty()){
			ResponseEntity.badRequest().body("Param cannot be emtpy");
		}
		List<PincodeResponseDTO> pincode =pincodeService.getPincodeByCity(cityName);
		return pincode.isEmpty()?ResponseEntity.ok().body("No data"): ResponseEntity.ok(pincode);
	}
	
	
	

}
