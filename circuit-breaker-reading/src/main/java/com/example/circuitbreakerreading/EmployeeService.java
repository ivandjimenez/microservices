package com.example.circuitbreakerreading;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class EmployeeService {
	
	private final RestTemplate restTemplate;

	public EmployeeService(RestTemplate restTemplate) {
		
		this.restTemplate = restTemplate;
	}
	
	@HystrixCommand(fallbackMethod="reliable")
	public String employeeList() {
		URI uri = URI.create("http://localhost:8080/employee");
		  return this.restTemplate.getForObject(uri, String.class);

	}

	public String reliable() {
		  return "{\"id\":{\"name\":\"Ivan Jimenez\",\"day\":\"18/03/2020\"},\"hours\":8.0,\"employeeId\":1751176}";
		  }

	
	
}
