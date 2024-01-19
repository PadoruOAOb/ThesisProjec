package com.example.dao;

import java.util.List;
import java.util.Optional;

import com.example.entiry.User;

public interface UserDao {

	List<User> findAllUsers();
	
	Optional<User> findUserByUsername(String username);
	
	Optional<User> findUserByUserId(Integer userId);
	
	int addUser(User user);
	
	int updateUserPassword(String password,Integer userId);
	
	int removeUser(Integer userId);
}
