package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.Admin;

@Repository
public interface IAdminRepository extends JpaRepositoryImplementation<Admin, Integer>{
	
}
