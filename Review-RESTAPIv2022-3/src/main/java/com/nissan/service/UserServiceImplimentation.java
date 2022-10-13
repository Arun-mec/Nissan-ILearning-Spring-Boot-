package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.dto.DtoUserLocationPost;
import com.nissan.model.User;
import com.nissan.repo.IUserRepository;

@Service
public class UserServiceImplimentation implements IUserService{
	
	@Autowired
	IUserRepository userRepo;

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepo.findAll();
	}

	@Override
	public List<DtoUserLocationPost> getAllUserLocationPost() {
		// TODO Auto-generated method stub
		return userRepo.getAllUserLocationPosts();
	}
	
	

}
