package com.task.bank.service;

import java.util.List;
import com.task.bank.response.dto.PincodeResponseDTO;


public interface PincodeService {
	
	
	public List<PincodeResponseDTO> getPincodeByCityId(Long cityId);

}
