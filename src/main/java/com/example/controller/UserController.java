package com.example.controller;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping("/register")
	// http://localhost:8080/ThesisProjec/mvc/user/register
	public String addUser(@ModelAttribute User user, Model model) {
		// 在這裡處理註冊邏輯，例如將用戶信息保存到數據庫中
		userDaoImpl.addUser(user);
		// 註冊成功後可以進行一些操作，例如顯示成功消息
		model.addAttribute("message", "註冊成功！");
		return "login";
	}

	// 轉跳登入的頁面
	@GetMapping("/login")
	public String login(HttpSession session) {
		return "login";
	}

//      前台登入處理
	@PostMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
// 						    @RequestParam("code") String code,
			HttpSession session, Model model) throws Exception {
		Optional<User> userOpt = userDaoImpl.findUserByUsername(username);
		if (userOpt.isPresent()) {
			User user = userOpt.get();
//    			// 將 password 進行 AES 加密 -------------------------------------------------------------------
//    			final String KEY = KeyUtil.getSecretKey();
//    			SecretKeySpec aesKeySpec = new SecretKeySpec(KEY.getBytes(), "AES");
//    			byte[] encryptedPasswordECB = KeyUtil.encryptWithAESKey(aesKeySpec, password);
//    			String encryptedPasswordECBBase64 = Base64.getEncoder().encodeToString(encryptedPasswordECB);
//    			//-------------------------------------------------------------------------------------------
			if (user.getPassword().equals(password)) { // 比對加密過後的 password 是否相同
				session.setAttribute("user", user); // 將 user 物件放入到 session 變數中
				return "redirect:/"; // OK, 導向前台首頁
			} else {
				session.invalidate(); // session 過期失效
				model.addAttribute("loginMessage", "密碼錯誤");
				return "/login";
			}
		} else {
			session.invalidate(); // session 過期失效
			model.addAttribute("loginMessage", "無此使用者");
			return "/login";
		}
	}

	// 轉跳註冊的頁面
	@GetMapping("/register")
	public String register(Model model) {
		return "register";
	}

	// 登出
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
		
	// 導入到數學課程業面
	@GetMapping("/math")
	public String math(Model model) {
		return "Math/Math";
	}
	
	//轉跳到三角函數的業面
	@GetMapping("/trigFunctions")
	public String TrigFunctions(Model model) {
		return "Math/Detailed/TrigFunctions";
	}
}
