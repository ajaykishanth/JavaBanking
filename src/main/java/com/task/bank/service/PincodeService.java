package com.task.bank.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.bank.entity.Pincode;
import com.task.bank.repo.PincodeRepo;
import com.task.bank.response.dto.PincodeResponseDTO;

@Service
public class PincodeService {
	
	private final PincodeRepo pincodeRepo;
	
	@Autowired
	public PincodeService(PincodeRepo pincodeRepo) {
		this.pincodeRepo = pincodeRepo;
	}
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public List<PincodeResponseDTO> getPincodeByCity(String cityName){
		List<Pincode> pincode =pincodeRepo.findByCityCityName(cityName);
		
		return pincode.stream()
				.map(pincodeObj -> modelMapper.map(pincodeObj, PincodeResponseDTO.class))
				.collect(Collectors.toList());
	}

}
