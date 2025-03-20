package com.task.bank.service;

import java.util.List;
import com.task.bank.response.dto.CityResponseDTO;



public interface CityService {

	
	
	public List<CityResponseDTO> getCitiesbyStateId(Long stateId);
	
	

}
