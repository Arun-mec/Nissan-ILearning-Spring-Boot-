package com.nissan.repo;

import org.springframework.data.repository.CrudRepository;

import com.nissan.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	User findByUsername(String username);

}
