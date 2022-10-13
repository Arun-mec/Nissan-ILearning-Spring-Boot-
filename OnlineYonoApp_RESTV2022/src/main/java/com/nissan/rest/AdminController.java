package com.nissan.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.Customer;
import com.nissan.repo.IAdminRepository;
import com.nissan.service.IAdminService;

@CrossOrigin
@RestController
@RequestMapping("api/admin/")
public class AdminController {
	
	@Autowired
	IAdminService adminService;
	
	// Getting all customers
	@GetMapping("/getallcustomers")
	public List<Customer> getAllCustomers(){
		return adminService.getAllCustomers();
	}
	
	// Getting a customer using account no
	@GetMapping("/getcustomer/{accno}")
	public Optional<Customer> getCustomer(@PathVariable int accno) {
		return adminService.getCustomer(accno);
	}
	
	// Adding a customer
	@PostMapping("/addcustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		customer.setAccountNo(customer.generateAccountNumber());
		customer.setAtmPin(customer.generateAtmNumber());
		return adminService.addCustomer(customer);
	}
	
	//Updating the mobile number of a customer
	@PutMapping("/updatecustomermobile/{accno}&{mobilenumber}")
	public void updateCustomer(@PathVariable int accno,@PathVariable int mobilenumber) {
		adminService.updateMobileNumber(mobilenumber,accno);
		System.out.println("Customer has been updated successfully");
	}
	
	//Updating the email address
	@PutMapping("/updatecustomeremail/{accno}&{email}")
	public void updateCustomer(@PathVariable int accno,@PathVariable String email) {
		adminService.updateEmail(email,accno);
		System.out.println("Customer has been updated successfully");
	}
	
	// Deleting a customer
	@PutMapping("/deletecustomer/{accno}")
	public void deleteCustomer(@PathVariable int accno) {
		adminService.deleteCustomer(accno);
		System.out.println("Customer has been deleted successfully");
	}
}
