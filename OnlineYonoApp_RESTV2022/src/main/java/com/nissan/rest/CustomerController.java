package com.nissan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.service.ICustomerService;

@CrossOrigin
@RestController
@RequestMapping("api/customer/")
public class CustomerController {
	
	@Autowired
	ICustomerService customerService;
	
	// Getting the balance
	@GetMapping("getbalance/{accno}")
	public double getBalance(@PathVariable int accno) { 
		return customerService.getBalance(accno);
	}
	
	// Deposit amount
	@PutMapping("deposit/{accno}")
	public double deposit(@PathVariable int accno,@RequestBody double depositamt) {
		double currentBalance = customerService.getBalance(accno);
		customerService.depositAmount(accno,currentBalance+depositamt);
		return currentBalance+depositamt;
	}
	
	// Withdraw balance
	@PutMapping("withdraw/{accno}")
	public double withdraw(@PathVariable int accno,@RequestBody double withdrawamt) {
		double currentBalance = customerService.getBalance(accno);
		customerService.withdrawAmt(accno,currentBalance-withdrawamt);
		return currentBalance+withdrawamt;
	}
}
