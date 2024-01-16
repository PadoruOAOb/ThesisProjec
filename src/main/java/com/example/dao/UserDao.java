package com.example.dao;

import java.util.List;
import java.util.Optional;

import com.example.entiry.User;

public interface UserDao {
//	使用者-User:
//	1. 查詢所有使用者(多筆)
	List<User> findAllUser();
	
//	2.增加使用者
	void addUser(User user);
	
//	3.根據使用者名稱查找使用者(登入用-單筆)
	Optional<User> findUserByUsername(String username);
	
//	4. 修改密碼
	Boolean updateUserPassword(Integer userId, String newPassword);
	
	
}
