package com.task.bank.service.impl;



import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GetAPI {
	
	
	private final RestTemplate restTemplate;
	
	public String getResponse(String name) {
		
		String apiUrl = "https://personal-w2ndsi6i.outsystemscloud.com/A/rest/New/Demo?Name="+name;
		
		return restTemplate.getForObject(apiUrl, String.class);
	}

}
