package com.prowings.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.myapp.model.Student;
import com.prowings.myapp.service.RestApiConsumeService;

@RestController
@RequestMapping("/consumeApi")
public class RestApiConsumeController {

	@Autowired
	RestApiConsumeService service;
	
	@GetMapping("/getStudents")
	public ResponseEntity<List> getStudentDataFromRestApi()
	{
		System.out.println(">>> Received request to fetch Std detail from REST API!!");
		
		return service.getStds();
	}

}
