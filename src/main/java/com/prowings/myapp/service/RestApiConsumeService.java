package com.prowings.myapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.prowings.myapp.model.Student;

public interface RestApiConsumeService {
	
	public ResponseEntity<List> getStds();

	public ResponseEntity<String> createStd(Student std);

	public ResponseEntity<List> searchStudentByCity(String city);
	

}
