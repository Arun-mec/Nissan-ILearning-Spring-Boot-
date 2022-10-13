package com.nissan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tblSocuser")
public class User {
	
	// Entity fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private boolean isActive;
	private String userName;
	
	@JoinColumn(name="locationId",insertable=false,updatable=false)
	@ManyToOne			//Foreign key relation
	private Location userLoc;
	
	@JsonIgnore
    @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Post> posts;

	
	public User() {
		super();
	}

	// Parameterized constructor
	public User(int userId, boolean isActive, Location userLoc, List<Post> posts,String userName) {
		super();
		this.userId = userId;
		this.isActive = isActive;
		this.userLoc = userLoc;
		this.posts = posts;
		this.userName = userName;
	}

	// Getters and Setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@JsonBackReference
	public Location getUserLoc() {
		return userLoc;
	}
	
	public void setUserLoc(Location userLoc) {
		this.userLoc = userLoc;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	} 
	
	// toString
	@Override
	public String toString() {
		return "User [userId=" + userId + ", isActive=" + isActive + ", userLoc=" + userLoc + ", posts=" + posts + "]";
	}
	
}
