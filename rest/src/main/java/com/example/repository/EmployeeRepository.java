package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;
import com.example.entity.EmployeeId;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, EmployeeId> {

	public List<Employee> findByHours(Double hours);

	public List<Employee> findByEmployeeId(Integer employeeId);

}
