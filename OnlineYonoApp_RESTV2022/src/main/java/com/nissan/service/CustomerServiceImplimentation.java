package com.nissan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.model.Customer;
import com.nissan.repo.ICustomerRepository;

@Service
public class CustomerServiceImplimentation implements ICustomerService{
	
	@Autowired
	ICustomerRepository customerRepo;

	@Override
	public double getBalance(int accNo) {
		// TODO Auto-generated method stub
		return customerRepo.getBalance(accNo);
	}

	@Override
	public void depositAmount(int accno, double depositAmt) {
		// TODO Auto-generated method stub
		customerRepo.depositAmount(accno,depositAmt);
	}

	@Override
	public void withdrawAmt(int accno, double withdrawamt) {
		// TODO Auto-generated method stub
		customerRepo.withdrawAmt(accno,withdrawamt);
	}

}
