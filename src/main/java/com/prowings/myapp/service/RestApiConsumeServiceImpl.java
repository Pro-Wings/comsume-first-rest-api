package com.prowings.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prowings.myapp.model.Student;

@Service
public class RestApiConsumeServiceImpl implements RestApiConsumeService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ResponseEntity<List> getStds() {

		System.out.println(">>>> student service :: getStd() started!!");
		// call to rest api

		String uri = "http://localhost:8084/my-first-student-rest-api/students";

//		Student fetchedStd = restTemplate.getForObject(uri, Student.class);

		ResponseEntity<List>  fetchedStd = restTemplate.getForEntity(uri, List.class);

		System.out.println(">>> received Std from REST Api : " );
		System.out.println(">>> Response Body : "+ fetchedStd.getBody());
		System.out.println(">>> Response Status : "+ fetchedStd.getStatusCodeValue());

		return fetchedStd;
	}

}
