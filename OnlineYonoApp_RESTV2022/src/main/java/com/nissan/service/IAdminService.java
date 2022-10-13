package com.nissan.service;

import java.util.List;
import java.util.Optional;

import com.nissan.model.Customer;


public interface IAdminService {
	
	// Finding all the customers
	public List<Customer> getAllCustomers();
	
	// Display the details of a customer
	public Optional<Customer> getCustomer(int accNo);
	
	// Adding a customer
	public Customer addCustomer(Customer customer);
	
	// Updating a customer
	public void updateMobileNumber(int mobileNumber,int accNo);
	
	// Updating a customer
	public void updateEmail(String email,int accNo);
	
	// Deleting a customer
	public void deleteCustomer(int accNo);

}
