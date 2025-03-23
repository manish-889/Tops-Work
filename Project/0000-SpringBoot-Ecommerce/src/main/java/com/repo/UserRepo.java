package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

//	@Query("select u from User u Where u.email=:email AND u.password=:password ")
	public User findByEmailAndPassword(String email,String password);
	
	
}
