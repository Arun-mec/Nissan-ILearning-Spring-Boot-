package com.nissan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.dto.DtoUserLocationPost;
import com.nissan.model.User;
import com.nissan.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@GetMapping("users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("usersposts")
	public List<DtoUserLocationPost> getAllUserLocationPosts(){
		return userService.getAllUserLocationPost();
	}

}
