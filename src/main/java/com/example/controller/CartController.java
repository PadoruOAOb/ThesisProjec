package com.example.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.example.dao.UserDao;
import com.example.entiry.CartItem;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@PostMapping("/addToCart")
    public String addToCart(@RequestParam("cartItemJson") String cartItemJson, HttpSession session) {
		return cartItemJson;

    }

  
    @GetMapping("/cart")
    public String viewCart(HttpSession session, Model model) {

        return "cart"; // 購物車頁面的JSP
    }

}

