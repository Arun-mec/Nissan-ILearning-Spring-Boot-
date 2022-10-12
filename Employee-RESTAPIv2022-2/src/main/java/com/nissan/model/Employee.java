package com.nissan.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tblEmployee")
public class Employee {

	//entity fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	
	@Column(nullable=false,unique=true)
	private String empName;
	
	@Column(nullable=false,unique=true)
	private String empDesignation;
	
	private LocalDate doj;
	private double empSalary;
	private int empPhone;
	
	@JoinColumn(name="deptId")
	@ManyToOne
	private Department dpt;
	
	// default constructors
	public Employee() {
		super();
	}

	// paramteric constructor
	public Employee(String empName, String empDesignation, LocalDate doj, double empSalary, int phone, Department dpt) {
		super();
		this.empName = empName;
		this.empDesignation = empDesignation;
		this.doj = doj;
		this.empSalary = empSalary;
		this.dpt = dpt;
		this.empPhone = phone;
	}

	// getters and setters
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getEmpDesignation() {
		return empDesignation;
	}
	
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	
	public LocalDate getDoj() {
		return doj;
	}
	
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	
	public double getEmpSalary() {
		return empSalary;
	}
	
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	
	public double getEmpPhone() {
		return empPhone;
	}
	
	public void setEmpPhone(int empPhone) {
		this.empPhone = empPhone;
	}
	
	public Department getDpt() {
		return dpt;
	}
	
	public void setDpt(Department dpt) {
		this.dpt = dpt;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDesignation=" + empDesignation + ", doj="
				+ doj + ", empSalary=" + empSalary + ", dpt=" + dpt + "]";
	}
	
	
	
}
