package com.example.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.entity.Employee;
import com.example.entity.EmployeeId;

@Repository
@Transactional
public class EmployeeDAOService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Employee insert(Employee employee)
	{
		entityManager.persist(employee);
		return employee;
	}
	
}
