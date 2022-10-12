package com.nissan.service;

import java.util.List;
import java.util.Optional;

import com.nissan.model.Employee;

public interface IEmployeeService {

	// Getting all employees
	public List<Employee> getAllEmployees();
	
	// Adding an employee
	public Employee addEmployee(Employee emp);
	
	// Updating an employee
	public Employee updateEmployee(Employee emp);
	
	// Search by id
	public Optional<Employee> searchEmployeeById(int empId);
	
	// Delete by id
	public Employee deleteEmployee(int empId);
	
}
