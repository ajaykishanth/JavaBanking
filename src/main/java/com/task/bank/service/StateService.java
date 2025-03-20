package com.task.bank.service;


import java.util.List;
import com.task.bank.response.dto.StateResponseDTO;


public interface StateService {
	
	public List<StateResponseDTO> getStateListByCountryId(Long countryId);
	
}
