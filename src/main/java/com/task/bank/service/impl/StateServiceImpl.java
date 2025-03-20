package com.task.bank.service.impl;


import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.task.bank.entity.State;
import com.task.bank.repository.StateRepository;
import com.task.bank.response.dto.StateResponseDTO;
import com.task.bank.service.StateService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StateServiceImpl implements StateService{
	
	
	
	private final StateRepository stateRepo;
	private final ModelMapper modelMapper;

	
	
	public List<StateResponseDTO> getStateListByCountryId(Long countryId){
		
		List<State> state = stateRepo.findByCountryCountryId(countryId);
		return state.stream()
	            .map(stateObj -> modelMapper.map(stateObj, StateResponseDTO.class))
	            .collect(Collectors.toList());
	
	}

	
	
	
}
