package com.example.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="Employee")
public class Employee {

	@EmbeddedId
    private EmployeeId id;
	
	@Column(name="Hours")
	private double hours;
	@Column(name = "Id")
    private int employeeId;
	@Column(name="Location")
	@JsonIgnore
	private String location;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Employee(EmployeeId id, double hours, int employeeId, String location) {
		super();
		this.id = id;
		this.hours = hours;
		this.employeeId = employeeId;
		this.location = location;
	}



	public int getEmployeeId() {
		return employeeId;
	}



	public EmployeeId getId() {
		return id;
	}
	public double getHours() {
		return hours;
	}
	public String getLocation() {
		return location;
	}
	
	
		
}
