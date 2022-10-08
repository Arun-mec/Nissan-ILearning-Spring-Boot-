package com.nissan.repo;

public interface IUserRepo {
	
	// Add user
	public void addUser();
	
	// Edit user
	public void updateUser();
	
	// Disable user
	public void disableUser();
	
	// List all users
	public void listUsers();
	
	// Search by name
	public void searchUser();
}
