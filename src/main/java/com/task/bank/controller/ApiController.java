package com.task.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.bank.service.impl.GetAPI;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/personalapi")
@AllArgsConstructor
public class ApiController {
	
	private final GetAPI getAPI;
	
	
	@GetMapping("/{name}")
	public String getResponse(@PathVariable("name") String name ) {
		return getAPI.getResponse(name);
	}
	
	

}
