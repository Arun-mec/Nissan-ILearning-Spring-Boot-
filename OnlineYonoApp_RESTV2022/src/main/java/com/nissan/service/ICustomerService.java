package com.nissan.service;

import java.util.Optional;

import com.nissan.model.Customer;

public interface ICustomerService {
	
	// Depositing money to the customer account
	public void depositAmount(int accno, double depositAmt);
	
	// Withdraw money from the account
	public void withdrawAmt(int accno, double withdrawamt);
	
	// Show balance of a customer
	public double getBalance(int accNo);

	// Transfer money to another account
}
