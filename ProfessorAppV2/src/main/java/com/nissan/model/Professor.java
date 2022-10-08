package com.nissan.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

// JPA to map this model to professor table in database

@Entity
@Table(name="Professor")
@NamedQueries({
	@NamedQuery(name="Professor.finByName",query="SELECT p FROM Professor p WHERE p.firstName=:name")
})
public class Professor {
	
	//declare fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int professorId;
	private String firstName;
	private String lastName;
	private int deptNo;
	private double salary;
	private LocalDate joinDtae;
	private LocalDate dateOfBirth;
	private String gender;
	
	//default constructor
	public Professor() {
		super();
	}

	//paramaterized constructor
	public Professor(int professorId, String firstName, String lastName, int deptNo, double salary, LocalDate joinDtae,
			LocalDate dateOfBirth, String gender) {
		super();
		this.professorId = professorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.deptNo = deptNo;
		this.salary = salary;
		this.joinDtae = joinDtae;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}

	//getters and setters
	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getJoinDtae() {
		return joinDtae;
	}

	public void setJoinDtae(LocalDate joinDtae) {
		this.joinDtae = joinDtae;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	
	//custom methods
	//overriding
	@Override
	public String toString() {
		return "Professor [professorId=" + professorId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", deptNo=" + deptNo + ", salary=" + salary + ", joinDtae=" + joinDtae + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + "]";
	}
	

}
