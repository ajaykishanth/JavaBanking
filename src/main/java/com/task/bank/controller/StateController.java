package com.task.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.task.bank.response.dto.StateResponseDTO;
import com.task.bank.service.StateService;

@RestController
@RequestMapping("/state")
public class StateController {
	
	
	
	private final StateService stateService;
	
	@Autowired
	public StateController(StateService stateService) {
		this.stateService =stateService;
	}
	
	

	
	
	
	@GetMapping("/by-country")
	public ResponseEntity<List<StateResponseDTO>>  getStateList(@RequestParam String countryname){
		List<StateResponseDTO> stateList = stateService.getStateListByCountryName(countryname);
		if(stateList.isEmpty()) {
			return ResponseEntity.noContent().build(); 
		}
		 return ResponseEntity.ok(stateList); 
		
	}
}
