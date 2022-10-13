package com.nissan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.model.Customer;
import com.nissan.repo.IAdminRepository;
import com.nissan.repo.ICustomerRepository;

@Service
public class AdminServiceImplimentation implements IAdminService{
	
	@Autowired
	ICustomerRepository customerRepo;

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

	@Override
	public Optional<Customer> getCustomer(int accNo) {
		// TODO Auto-generated method stub
		return customerRepo.findByCustomerAccountNo(accNo);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		customerRepo.save(customer);
		return customer;
	}

	@Override
	public void deleteCustomer(int accNo) {
		// TODO Auto-generated method stub
		customerRepo.deleteById(accNo);
	}

	@Override
	public void updateMobileNumber(int mobileNumber, int accNo) {
		// TODO Auto-generated method stub
		customerRepo.updateCustomerMobile(mobileNumber, accNo);
		
	}

	@Override
	public void updateEmail(String email, int accNo) {
		// TODO Auto-generated method stub
		customerRepo.updateCustomerEmail(email, accNo);
		
	}
	
}
