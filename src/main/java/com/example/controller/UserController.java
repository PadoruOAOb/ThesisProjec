package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.UserDao;

/**
 * http://localhost:8080/ThesisProjec/mvc/user/all
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired()
	@Qualifier("userDaoImpl")
	UserDao userDaoImpl;
	
	@GetMapping("/all")
	@ResponseBody
	public String getAllUser() {
		return userDaoImpl.findAllUser().toString();
	}
}
