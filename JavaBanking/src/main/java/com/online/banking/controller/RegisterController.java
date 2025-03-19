package com.online.banking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RegisterController {

	@GetMapping("health-check")
	public ResponseEntity<String> healthCheck() {
		return ResponseEntity.status(HttpStatus.OK).body("This is my test");
	}
}
