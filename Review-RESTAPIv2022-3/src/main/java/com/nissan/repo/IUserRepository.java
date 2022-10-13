package com.nissan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.dto.DtoUserLocationPost;
import com.nissan.model.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Integer>{
	
	// CUstom JPQL Query which is retrievinf
	//Userid,username,locationname,postDetails
	//from user, location and post basef on pk fk relationship
	@Query("SELECT new com.nissan.dto.DtoUserLocationPost (u.userId,u.userName,l.locationName,p.postName)"
			+ "FROM User u INNER JOIN u.userLoc l "
			+ "INNER JOIN u.posts p ORDER BY u.userId")
	List<DtoUserLocationPost> getAllUserLocationPosts();
	

}
