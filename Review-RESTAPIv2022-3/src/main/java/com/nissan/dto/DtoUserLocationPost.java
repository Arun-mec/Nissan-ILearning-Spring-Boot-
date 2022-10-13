package com.nissan.dto;

public class DtoUserLocationPost {
	
	// Field names
	private Integer id;
	private String userName;
	private String name;
	private String details;
	
	public Integer getId() {
		return id;
	}
	
	// Default constructors
	public DtoUserLocationPost() {
	}

	//parameterised constructors
	public DtoUserLocationPost(Integer id, String userName, String name, String details) {
		super();
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.details = details;
	}


	// getters and setters
	public void setId(Integer id) {
		this.id = id;
	}
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

	// Default constructors
	
}
