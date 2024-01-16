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
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	//轉跳購物車頁面
	@GetMapping("/cart")
	public String cart(HttpSession session) {
		return "Cart/Cart";
	}
	
	//轉跳到我的課程
	@GetMapping("/MyCourses")
	public String MyCourses(HttpSession session) {
		return "MyCourses/MyCourses";
	}
	
	//轉跳到以擁有課程
	@GetMapping("/Test001")
	public String Test001(HttpSession session) {
		return "MyCourses/OwnedCourses/Test001";
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

	// 轉跳到三角函數的業面
	@GetMapping("/trigFunctions")
	public String TrigFunctions(Model model) {
		return "Math/Detailed/TrigFunctions";
	}

	// 轉跳到日文課程頁面
	@GetMapping("/japan")
	public String japan(Model model) {
		return "Japan/Japan";

	}
	//
	@GetMapping("/ChangePassword")
	public String ChangePassword(Model model) {
		return "/ChangePassword/ChangePassword";
	}
	// 密碼變更		
		@RequestMapping(value = "/ChangePassword", method = RequestMethod.POST)
		public String changePassword(@RequestParam("oldPassword") String oldPassword, 
									 @RequestParam("newPassword") List<String> newPasswords,
									 HttpSession session,
									 Model model) throws Exception {
			
			User user = (User)session.getAttribute("user");
			
			// 將 password 進行 AES 加密 -------------------------------------------------------------------
			//final String KEY = KeyUtil.getSecretKey();
			//SecretKeySpec aesKeySpec = new SecretKeySpec(KEY.getBytes(), "AES");
			//byte[] encryptedOldPasswordECB = KeyUtil.encryptWithAESKey(aesKeySpec, oldPassword);
			//String encryptedOldPasswordECBBase64 = Base64.getEncoder().encodeToString(encryptedOldPasswordECB);
			//-------------------------------------------------------------------------------------------
			
			if(!user.getPassword().equals(oldPassword)) {
				model.addAttribute("errorMessage", "原密碼錯誤");
				return "/ChangePassword/ChangePassword";
			}
			if(!newPasswords.get(0).equals(newPasswords.get(1))) {
				model.addAttribute("errorMessage", "二次新密碼不一致");
				return "/ChangePassword/ChangePassword";
			}
			// 將新密碼加密
			//byte[] encryptedNewPasswordECB = KeyUtil.encryptWithAESKey(aesKeySpec, newPasswords.get(0));
			//String encryptedNewPasswordECBBase64 = Base64.getEncoder().encodeToString(encryptedNewPasswordECB);
			// 進行密碼變更
			userDaoImpl.updateUserPassword(user.getUserId(), newPasswords.get(1));
			return "redirect:/mvc/user/login";
		}
}
