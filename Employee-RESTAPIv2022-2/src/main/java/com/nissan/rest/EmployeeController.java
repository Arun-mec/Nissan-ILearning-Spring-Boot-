package com.nissan.rest;

import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.Employee;
import com.nissan.service.IEmployeeService;

@CrossOrigin
@RestController
@RequestMapping("api/")
public class EmployeeController {
	
	// Declaring the employee service
	@Autowired
	IEmployeeService empService;
	
	//Reading the data
	@GetMapping("employees")
	public List<Employee> getEmployees(){
		return empService.getAllEmployees();
	}
	
	//Reading the data
	@PostMapping("employees")
	public Employee addEmployee(@RequestBody Employee emp){
		return empService.addEmployee(emp);
	}
	
	//Reading the data
	@PutMapping("employee")
	public Employee updateEmployee(@RequestBody Employee emp){
		System.out.println("Updating an employee..");
		return empService.updateEmployee(emp);
	}
	
	// Search by id
	@GetMapping("employee/{empId}")
	public Optional<Employee> getEmployee(@PathVariable int empId){
		System.out.println("Searching...");
		return empService.searchEmployeeById(empId);
	}
	
	@PutMapping("employee/{empId}")
	public Employee deleteEmployee(@PathVariable int empId) {
		System.out.println("Deleting the employee..");
		return empService.deleteEmployee(empId);
	}
	
}
