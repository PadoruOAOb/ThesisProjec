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
        // 將JSON字符串轉換為CartItem對象
        Gson gson = new Gson();
        CartItem cartItem = gson.fromJson(cartItemJson, CartItem.class);

        // 獲取購物車或創建購物車
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        // 將CartItem添加到購物車
        cart.add(cartItem);

        return "redirect:/mvc/user/newCart";
    }

  
    @GetMapping("/cart")
    public String viewCart(HttpSession session, Model model) {
        // 獲取購物車
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            for (CartItem item : cart) {
                System.out.println("CartItem: " + item.getcourse() + " - " + item.getPrice());
            }
        }
        // 將購物車項目傳遞到視圖
        model.addAttribute("courses", cart);  // 將購物車設置為courses

        return "cart"; // 購物車頁面的JSP
    }

}

