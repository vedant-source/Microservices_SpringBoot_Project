package com.user.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.dao.UserService;
import com.user.service.dto.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService service;

	// Save New User To Db
	@PostMapping("/addUser")
	private ResponseEntity<User> createUser(@RequestBody User user) {
		System.out.println("hitted addUser...");
		User createdUser = service.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}

	// Fetch Single user by Id from Db
	@GetMapping("/getUser/{userId}")
	private ResponseEntity<User> getUserById(@PathVariable String userId) {
		User userById = service.getUserById(userId);
		return ResponseEntity.ok(userById);
	}

	// Fetch ALL users by Id from Db
	@GetMapping("/getAllUsers")
	private ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = service.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}

	// Delete User By ID
	@GetMapping("/deleteUserById/{userId}")
	private String deleteUserById(@PathVariable String userId) {
		service.deleteUserById(userId);
		String ok = "User Deleted Successfully";
		return ok;
	}

	// Update user using Id
	@PostMapping("/updateUser")
	private String updateUser(@RequestBody User user) {
		// User user2 = service.updateUserById(User user);
		service.updateUserById(user);
		String ok = "User Updated Successfully";
		return ok;
	}

}
