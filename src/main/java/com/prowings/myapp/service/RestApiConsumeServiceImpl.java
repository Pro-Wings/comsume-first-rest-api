package com.prowings.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import com.prowings.myapp.config.MyWebConfig;
import com.prowings.myapp.exception.NotFoundException;
import com.prowings.myapp.model.Student;

@Service
public class RestApiConsumeServiceImpl implements RestApiConsumeService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	Environment environment;
	
	
	@Override
	public ResponseEntity<List> getStds() {

		System.out.println(">>>> student service :: getStd() started!!");
		String uri = environment.getProperty("url");
		// call to rest api


//		Student fetchedStd = restTemplate.getForObject(uri, Student.class);

		ResponseEntity<List>  fetchedStd = restTemplate.getForEntity("/students", List.class);
		System.out.println(">>> received Std from REST Api : " );
		System.out.println(">>> Response Body : "+ fetchedStd.getBody());
		System.out.println(">>> Response Status : "+ fetchedStd.getStatusCodeValue());

		return fetchedStd;
	}


	@Override
	public ResponseEntity<String> createStd(Student std) {
		String uri = environment.getProperty("url");
			System.out.println("calling saveStudent resource of REST Api..");
//			ResponseEntity<String> response = restTemplate.postForEntity(uri, std, String.class);
			String response = restTemplate.postForObject("/students", std, String.class);
//			return response;
			return new ResponseEntity<>(response, HttpStatus.CREATED);

	}


	private boolean validStudent(Student std) {
		if(std.getName().length() >= 4)
			return true;
		else
			return false;
	}


	@Override
	public ResponseEntity<List> searchStudentByCity(String city) {
		System.out.println("inside service::searchStudentByCity()");
		ResponseEntity<List>  fetchedStds = null;
//		try {
			fetchedStds = restTemplate.getForEntity("/students/searchaa/?city="+city, List.class);
//		}catch (HttpClientErrorException e) {
//			System.out.println("Client side error!!");
//			e.printStackTrace();
//			throw new NotFoundException("Resourse not found on target api!!");
//			//throw ex and handle it in global ex handler
//		}catch (HttpServerErrorException e) {
//			System.out.println("Server side error!!");
//			e.printStackTrace();
//			throw e;
//			//throw ex and handle it in global ex handler
//		}catch (UnknownHttpStatusCodeException e) {
//			System.out.println("unknownen error!!");
//			e.printStackTrace();
//			//throw ex and handle it in global ex handler
//		}catch (Exception e) {
//			System.out.println("some error!!");
//			e.printStackTrace();
//			//throw ex and handle it in global ex handler
//		}

		return fetchedStds;
	}

}
