package com.nissan.model;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tblCustomer")
public class Customer {
	
	// Entity Variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	
	@Column(length = 9)
	private int accountNo;
	
	@Column(length = 30)
	private String customerName;
	private String accountType;
	private double accountBalance;
	private double minBalance;
	
	@Column(nullable = false,length = 10)
	private long mobileNumber;
	private String emailId;
	
	@Column(nullable = false,length = 4)
	private int atmPin;
	
	@JoinColumn(name="adminId")
	@ManyToOne
	private Admin admin;
	
	// Default constructor
	public Customer() {
		super();
	}


	// Parameterised constructor
	public Customer(int accountNo, String customerName, String accountType, double accountBalance, double minBalance,
			long mobileNumber, String emailId, int atmPin, Admin admin) {
		super();
		this.accountNo = accountNo;
		this.customerName = customerName;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.minBalance = minBalance;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.atmPin = atmPin;
		this.admin = admin;
	}


	// Getters and setters
	public int getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public double getAccountBalance() {
		return accountBalance;
	}


	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}


	public double getMinBalance() {
		return minBalance;
	}


	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}


	public long getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public int getAtmPin() {
		return atmPin;
	}


	public void setAtmPin(int atmPin) {
		this.atmPin = atmPin;
	}


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}


	@Override
	public String toString() {
		return "Customer [accountNo=" + accountNo + ", customerName=" + customerName + ", accountType=" + accountType
				+ ", accountBalance=" + accountBalance + ", minBalance=" + minBalance + ", mobileNumber=" + mobileNumber
				+ ", emailId=" + emailId + ", atmPin=" + atmPin + ", admin=" + admin + "]";
	}
	
	// methods
	public int generateAccountNumber() {
		Random randAccNo=new Random();
		return (100000000 + randAccNo.nextInt(900000000));
	}
	
	public int generateAtmNumber() {
		Random randAccNo=new Random();
		return (1000 + randAccNo.nextInt(9000));
	}
}
