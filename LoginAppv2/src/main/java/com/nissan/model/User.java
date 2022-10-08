package com.nissan.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {

	//instance variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String userPassword;
	private String roleId;
	private LocalDate createdDate;
	
	//default function
	public User() {
		super();
	}

	//parameterized constructor
	public User(int userId, String userName, String userPassword, String roleId, LocalDate createdDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.roleId = roleId;
		this.createdDate = createdDate;
	}

	// getters and setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

//	overriding
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", roleId="
				+ roleId + ", createdDate=" + createdDate + "]";
	}
	
	
	

}
