package com.example.restcontroller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.entity.Employee;
import com.example.entity.EmployeeId;
import com.example.exception.EmployeeNotFoundException;
import com.example.repository.EmployeeRepository;

@RestController
public class EmployeeRestController {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeRestController.class);
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee()
	{
		List <Employee> employees = employeeRepository.findAll();
		log.info("List of employees: "+ employees.toString());
		return employees;
	}
	
	@GetMapping("/employee/{employeeId}/day")
	@ResponseBody
	public Optional<Employee> getEmployeeByDay(@PathVariable("employeeId") String name)
	{
		EmployeeId employeeId = new EmployeeId(name,"18/03/2020");
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if (!employee.isPresent())
			throw new EmployeeNotFoundException("Employee not found id: "+ name);
		return employee;
	}
	
	@GetMapping("/employee/{hours}/hours")
	@ResponseBody
	public List<Employee> getEmployeeHours(@PathVariable double hours)
	{
		
		List<Employee> employee = employeeRepository.findByHours(hours);
		if (employee.isEmpty())
			throw new EmployeeNotFoundException("No Employee found with "+ hours+" hours.");

				return employee;
	}
	
	
	@GetMapping("/employee/{employeeId}")
	@ResponseBody
	public List<Employee> getEmployee(@PathVariable int employeeId)
	{
		
		List<Employee> employee = employeeRepository.findByEmployeeId(employeeId);
		if (employee.isEmpty())
			throw new EmployeeNotFoundException("Employee "+ employeeId+" not found.");

				return employee;
	}
	
    
	@PostMapping("/employee")
	public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee employee )
	{
		
		Employee savedEmployee = employeeRepository.save(employee);
		log.info("New employee is created: "+ employee.toString());
	
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest().
		path("/{employeeId}").
		buildAndExpand(savedEmployee.getEmployeeId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/employeeByDay/{employeeId}")
	@ResponseBody
	public void deleteEmployeeByDay(@PathVariable String name)
	{
		EmployeeId employeeId = new EmployeeId(name, "18/03/2020");
		try {
			employeeRepository.deleteById(employeeId);
			log.info("Employee is delete: "+ employeeId.toString());

		}
		catch(IllegalArgumentException e)
		{
			log.error("The employee "+ employeeId.toString()+" could not be found.");
			throw new EmployeeNotFoundException("Employee not found id: "+ name);
		}
		
	}
}
