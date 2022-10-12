package com.nissan.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.model.Employee;
import com.nissan.repo.IEmployeeRepository;

@Service
public class EmployeeServicesImpl implements IEmployeeService{

	@Autowired
	IEmployeeRepository empRepo;
	
	// Getting all employee data
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empRepo.save(emp);
	}
	
	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empRepo.save(emp);
	}

	@Override
	public Optional<Employee> searchEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return empRepo.findEmployeeById(empId);
	}

	@Override
	public Employee deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		empRepo.deleteById(empId);
		return null;
	}


}
