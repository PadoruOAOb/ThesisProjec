package com.example.dao;

import java.util.List;
import java.util.Optional;

import com.example.entiry.Cart;
import com.example.entiry.CartItem;
import com.example.entiry.User;

public interface CartDao {
	
//	1. 查詢所有商品(多筆)--測試成功
	List<Cart> findAllCarts();
    
//	2. 新增購物車--測試成功
	int addCart(Cart cart);
	
//	3. 根據購物車ID查找購物車資料(單筆)--測試成功
	Optional<Cart> findCartById(Integer cartId);
	
//	4. 根據使用者ID及結帳狀態來查找其所有購物車資料(多筆)--測試成功
	List<Cart> findCartsbyUserIdAndCheckoutStatus(Integer userId, Integer isCheckout);
	
//	5. 根據使用者ID來查找其未結帳的購物車資料(單筆)--測試成功
	Optional<Cart> findNoneCheckoutCartByUserId(Integer userId);
	
//	6.根據使用者ID將該使用者的購物車設置為已結帳狀態(前台的事件)
	int checkoutCartByUserId(Integer userId);
	
//	7. 根據購物車ID將購物車設置為已結帳狀態(後台的事件)	
	int checkoutCartById(Integer cartId) ;

}