package com.task.bank.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.task.bank.service.impl.StudentServiceImpl;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	 @PostMapping("/upload")
	    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
	        try {
	           
	            Path path = Paths.get(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());
	            file.transferTo(path.toFile());
	            studentServiceImpl.porcessExcelFile(path.toFile());
	            Files.delete(path);

	            return ResponseEntity.ok("File uploaded and data processed successfully.");
	        } catch (IOException e) {
	            return ResponseEntity.status(500).body("Error occurred while processing the file.");
	        }
	        
	 }
}
