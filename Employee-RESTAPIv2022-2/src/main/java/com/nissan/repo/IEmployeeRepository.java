package com.nissan.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepositoryImplementation<Employee, Integer>{
	
	@Query("from Employee where empId=?1")
	public Optional<Employee> findEmployeeById(int empId);
	
}
