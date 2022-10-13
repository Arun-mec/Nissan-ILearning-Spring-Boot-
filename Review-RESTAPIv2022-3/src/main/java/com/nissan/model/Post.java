package com.nissan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tblPost")
public class Post {
	
	// Entitiy fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	private String postName;
	private int postLike;
	
	@JoinColumn(name="userId")
	@ManyToOne
	private User user;
	
	// Default constructor
	public Post() {
		super();
	}
	
	// Parameterised constructor
	public Post(int postId, String postName, int postLike, User user) {
		super();
		this.postId = postId;
		this.postName = postName;
		this.postLike = postLike;
		this.user = user;
	}


	// Getters and setters
	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public int getPostLike() {
		return postLike;
	}

	public void setPostLike(int postLike) {
		this.postLike = postLike;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
