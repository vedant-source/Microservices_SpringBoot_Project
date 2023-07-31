package com.user.service.daoimpl;

import java.util.List;
import com.user.service.countService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.service.dao.UserService;
import com.user.service.dto.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private CountValueService countvalueservice;

	@Override
	public User saveUser(User user) {
		int countval=countvalueservice.getUserCount();
		System.out.println(countval);
		++countval;
		String var="UID000"+String.valueOf(countval);
		user.setUserId(var);
		return repository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User With the given Id :" + "(" + id + ")" + "doesn't exist !"));
	}

	@Override
	public void deleteUserById(String id) {
		// TODO Auto-generated method stub
		User user = getUserById(id);
		repository.delete(user);
	}

	@Override
	public User updateUserById(User user) {
		// TODO Auto-generated method stub
		String id = user.getUserId();
		User updateUser = getUserById(id);
		if (updateUser != null) {
			updateUser.setName(user.getName());
			updateUser.setEmail(user.getEmail());
			updateUser.setAbout(user.getAbout());

			repository.save(updateUser);
		} else {
			throw new ResourceNotFoundException("User you want to update doesn't Exist. Try with Valid UserId.");
		}
		return null;
	}

}
