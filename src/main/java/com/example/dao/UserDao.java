package com.example.dao;

import java.util.List;

import com.example.entiry.User;

public interface UserDao {
//	使用者-User:
//	1. 查詢所有使用者(多筆)
	List<User> findAllUser();
	
//	2.增所有使用者
	void addUser(User user);
	
}
