package com.user.service.dao;

import java.util.List;

import com.user.service.dto.User;

public interface UserService {

	// create
	User saveUser(User user);

	// get all users
	List<User> getAllUsers();

	// get user by Id
	User getUserById(String id);

	// delete user by id
	void deleteUserById(String id);

	// Update user by id
	User updateUserById(User user);

}
