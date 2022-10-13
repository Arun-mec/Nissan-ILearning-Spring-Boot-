package com.nissan.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.nissan.model.Customer;

public interface ICustomerRepository extends JpaRepositoryImplementation<Customer, Integer>{

	@Query("update Customer c set c.mobileNumber = ?1 where c.accountNo= ?2 ")
	public void updateCustomerMobile(int mobileNumber,int accNo);
	
	@Query(value = "select * FROM Customer c where accountNo = ?1",nativeQuery=true)
	public Optional<Customer> findByCustomerAccountNo(int accNo);
	
	@Query("update Customer c set c.emailId =?1 where c.accountNo = ?2")
	public void updateCustomerEmail(String email,int accNo);
	
	@Query(value = "SELECT c.accountBalance FROM Customer c where c.accountNo = ?1")
	public double getBalance(int accNo);
	
	@Query("update Customer c set c.accountBalance = ?2 where c.accountNo = ?1") 
	public void depositAmount(int accNo,double depositAmt);

	@Query("update Customer c set c.accountBalance = ?2 where c.accountNo = ?1") 
	public void withdrawAmt(int accno, double withdrawamt);
}
