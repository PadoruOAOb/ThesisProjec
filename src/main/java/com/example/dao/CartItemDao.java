package com.example.dao;

import java.util.List;
import java.util.Map;

import com.example.entiry.CartItem;

public interface CartItemDao {

	List<CartItem> findAllCartItems();

	int addCartItem(CartItem cartItem);

    // 刪除特定購物車中特定課程的項目
    void deleteCartItemByCourse(Integer cartId, Integer courseId);
     
    List<CartItem> findCartItemsByUserIdAndCheckout(int userId);
    
    List<Map<String, Object>> calculateTotalAmountPerUser();
    

    
}
