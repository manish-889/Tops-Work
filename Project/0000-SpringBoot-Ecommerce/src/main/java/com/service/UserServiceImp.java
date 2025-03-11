package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repo.UserRepo;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	UserRepo repo;

	@Override
	public void addOrUpdateUser(User u) {
		// TODO Auto-generated method stub
		repo.save(u);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow();
	}

}
