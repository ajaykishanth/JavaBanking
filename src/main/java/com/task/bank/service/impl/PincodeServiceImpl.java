package com.task.bank.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.task.bank.entity.City;
import com.task.bank.entity.Pincode;
import com.task.bank.repository.CityRepository;
import com.task.bank.repository.PincodeRepository;
import com.task.bank.response.dto.PincodeResponseDTO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PincodeServiceImpl {
	
	private final PincodeRepository pincodeRepo;
	private final ModelMapper modelMapper;
	private final CityRepository cityRepo;
	
	
	public List<PincodeResponseDTO> getPincodeByCityId(Long cityId){
		
		Optional<City> city = cityRepo.findByCityId(cityId);
		if(city.isEmpty()) {
		return new ArrayList<PincodeResponseDTO>();		
		}
		List<Pincode> pincode =pincodeRepo.findByCityCityId(cityId);
		return pincode.stream()
				.map(pincodeObj -> modelMapper.map(pincodeObj, PincodeResponseDTO.class))
				.collect(Collectors.toList());
	}

}
