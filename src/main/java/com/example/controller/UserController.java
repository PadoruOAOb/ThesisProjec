package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
//  註冊 
	@PostMapping("/register")
	//http://localhost:8080/ThesisProjec/mvc/user/register	 
	public String addUser(@ModelAttribute User user, Model model) {
        // 在這裡處理註冊邏輯，例如將用戶信息保存到數據庫中
		userDaoImpl.addUser(user);
        // 註冊成功後可以進行一些操作，例如顯示成功消息
        model.addAttribute("message", "註冊成功！");
        return "login";        
	}
 
 //     轉跳登入的頁面
        @GetMapping("/login")
    	public String login(Model model) { 				
    		return "login";
    	}
      

        
}


	
