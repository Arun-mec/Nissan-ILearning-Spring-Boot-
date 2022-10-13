package com.nissan.service;

import java.util.List;

import com.nissan.dto.DtoUserLocationPost;
import com.nissan.model.User;

public interface IUserService {
	
	// Too get all users
	public List<User> getAllUsers();
	
	// to get all users-locations-posts
	public List<DtoUserLocationPost> getAllUserLocationPost();

}
