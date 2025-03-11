package com.service;

import java.util.List;

import com.model.User;

public interface UserService {

	public void addOrUpdateUser(User u);
	public List<User> getAllUser();
	public void deleteUser(int id);
	public User getUserById(int id);
	
}
