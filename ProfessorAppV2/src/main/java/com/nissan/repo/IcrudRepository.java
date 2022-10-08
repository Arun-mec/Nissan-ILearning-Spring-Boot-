package com.nissan.repo;

import java.util.Optional;

import com.nissan.model.Professor;

public interface IcrudRepository {
	
	//Create a professor
	public void insertEntity();
	
	//Read professors
	public void getProfessors();
	
	//Update a professor
	public void updateEntity();
	
	//Delete a professor
	public void deleteEntity();
	
	//Search by Id
	public void searchById();
	
	//Search by name
	public Optional<Professor> searchByName(String name);

}
