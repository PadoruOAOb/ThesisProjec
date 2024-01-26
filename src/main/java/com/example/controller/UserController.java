package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.CartDao;
import com.example.dao.CartItemDao;
import com.example.dao.CourseDao;
import com.example.dao.ResourceDao;
import com.example.dao.TypeDao;
import com.example.dao.UserDao;
import com.example.entiry.Cart;
import com.example.entiry.CartItem;
import com.example.entiry.Course;
import com.example.entiry.Resource;
import com.example.entiry.User;

/**
 * http://localhost:8080/ThesisProjec/mvc/user/all
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserDao userDaoImpl;

	@Autowired
	CourseDao courseDaoImpl;

	@Autowired
	CartItemDao cartItemDaoImpl;

	@Autowired
	TypeDao typeDaoImpl;

	@Autowired
	CartDao cartDaoImpl;

	@Autowired
	ResourceDao resourceDaoImpl;
	
//	@GetMapping("/all")
//	@ResponseBody
//	public String getAllUser() {
//		return userDaoImpl.findAllUser().toString();
//	}

	@GetMapping("/all")
	public String getAllUser(Model model) {

		List<User> users = userDaoImpl.findAllUsers();
		model.addAttribute("users", users);

		List<Course> courses = null;
		model.addAttribute("courses", courses);

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

	/**
	 * @param session
	 * @param model
	 * @return
	 */
	// 轉跳購物車頁面
	@GetMapping("/cart")
	public String cart(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		Optional<Cart> cartOpt = cartDaoImpl.findNoneCheckoutCartByUserId(user.getUserId());
		if (cartOpt.isPresent()) {
			Cart cart = cartOpt.get();
			List<CartItem> cartItems = cartItemDaoImpl.findCartItemsByCartId(cart.getCartId());
			model.addAttribute("cart", cartOpt.get());
		} else {
			model.addAttribute("message", "無購物訊息");
		}
		return "Cart/cart";
	}

	// 導入到數學課程業面
	@GetMapping("/math")
	public String math(HttpSession session,Model model) {
		User user = (User) session.getAttribute("user");
		int typeId = 1;
		List<Course> courses = typeDaoImpl.findCourseByTypeId(typeId);
		model.addAttribute("Course", courses);
		//前面是給前端渲染 後面反之
		System.out.println(courses);
		return "Math/Math";
	}
	
	
	
	// 轉跳到我的課程
	@GetMapping("/MyCourses")
	public String MyCourses(HttpSession session,Model model) {
		User user = (User) session.getAttribute("user");
		List<CartItem> cartItems = cartItemDaoImpl.findCartItemsByUserIdAndCheckout(user.getUserId());
		model.addAttribute("cartItems", cartItems);
		return "MyCourses/MyCourses";
	}
	
	// 轉跳到以擁有課程
	@GetMapping("/course/{courseId}")
	public String Test001(@PathVariable("courseId") Integer courseId,Model model) {
		
		Course course = courseDaoImpl.findCourseByCourseId(courseId).get();
		
		List<Resource> resources = resourceDaoImpl.findAllResourcesByCourseId(1);
		
		model.addAttribute("course", course);
		model.addAttribute("resources", resources);

		return "MyCourses/OwnedCourses/resources";
	}

	// 前台登入處理
	@PostMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
// 						    @RequestParam("code") String code,
			HttpSession session, Model model) throws Exception {
		Optional<User> userOpt = userDaoImpl.findUserByUsername(username);
		;
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

	// 轉跳測試購物車
	@GetMapping("/newCart")
	public String newCart(Model model) {
		return "webTest/newCart";
	}

	//	轉跳測試購買頁面
	@GetMapping("/Buy")
	public String Buy(Model model) {
		return "webTest/Buy";
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


	// 轉跳到三角函數的業面
	@GetMapping("/trigFunctions")
	public String TrigFunctions(Model model) {
		return "Math/Detailed/TrigFunctions";
	}

	// 轉跳到日文課程頁面
	@GetMapping("/japan")
	public String japan(HttpSession session,Model model) {
		User user = (User) session.getAttribute("user");
		int typeId = 2;
		List<Course> courses = typeDaoImpl.findCourseByTypeId(typeId);
		model.addAttribute("Course", courses);
		//前面是給前端渲染 後面反之
		System.out.println(courses);
		return "Math/Math";
	}

	// 轉跳更改密碼
	@GetMapping("/ChangePassword")
	public String ChangePassword(Model model) {
		return "/ChangePassword/ChangePassword";
	}

	// 密碼變更
	@RequestMapping(value = "/ChangePassword", method = RequestMethod.POST)
	public String changePassword(@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") List<String> newPasswords, HttpSession session, Model model) throws Exception {

		User user = (User) session.getAttribute("user");

		// 將 password 進行 AES 加密
		// -------------------------------------------------------------------
		// final String KEY = KeyUtil.getSecretKey();
		// SecretKeySpec aesKeySpec = new SecretKeySpec(KEY.getBytes(), "AES");
		// byte[] encryptedOldPasswordECB = KeyUtil.encryptWithAESKey(aesKeySpec,
		// oldPassword);
		// String encryptedOldPasswordECBBase64 =
		// Base64.getEncoder().encodeToString(encryptedOldPasswordECB);
		// -------------------------------------------------------------------------------------------

		if (!user.getPassword().equals(oldPassword)) {
			model.addAttribute("errorMessage", "原密碼錯誤");
			return "/ChangePassword/ChangePassword";
		}
		if (!newPasswords.get(0).equals(newPasswords.get(1))) {
			model.addAttribute("errorMessage", "二次新密碼不一致");
			return "/ChangePassword/ChangePassword";
		}

		// 將新密碼加密
		// byte[] encryptedNewPasswordECB = KeyUtil.encryptWithAESKey(aesKeySpec,
		// newPasswords.get(0));
		// String encryptedNewPasswordECBBase64 =
		// Base64.getEncoder().encodeToString(encryptedNewPasswordECB);
		// 進行密碼變更
		// userDaoImpl.updateUserPassword(user.getUserId(), newPasswords.get(1));

		return "redirect:/mvc/user/login";
	}

}
