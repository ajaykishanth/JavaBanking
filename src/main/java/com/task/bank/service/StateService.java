package com.task.bank.service;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.bank.entity.State;
import com.task.bank.repo.StateRepo;
import com.task.bank.response.dto.StateResponseDTO;

@Service
public class StateService {
	
	
	
	private final StateRepo stateRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	  @Autowired
	    public StateService(StateRepo stateRepo) {
	        this.stateRepo = stateRepo;
	    }
	
	
	public List<StateResponseDTO> getStateListByCountryName(String countryName){
		List<State> state = stateRepo.findByCountryCountryName(countryName);
		return state.stream()
	            .map(stateObj -> modelMapper.map(stateObj, StateResponseDTO.class))
	            .collect(Collectors.toList());
	
	}

	
	
	
}
