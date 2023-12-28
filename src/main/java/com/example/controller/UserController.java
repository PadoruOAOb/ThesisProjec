package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.UserDao;
import com.example.entiry.User;

/**
 * http://localhost:8080/ThesisProjec/mvc/user/all
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired()
	@Qualifier("userDaoImpl")
	UserDao userDaoImpl;
	
//	@GetMapping("/all")
//	@ResponseBody
//	public String getAllUser() {
//		return userDaoImpl.findAllUser().toString();
//	}
	
	@GetMapping("/all")
	public String getAllUser(Model model) {
		List<User> users = userDaoImpl.findAllUser();
		model.addAttribute("users", users);
		return "user_list";
	}
}
