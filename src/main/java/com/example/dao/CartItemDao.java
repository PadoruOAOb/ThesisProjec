package com.example.dao;

import java.util.List;
import java.util.Map;

import com.example.entiry.CartItem;

public interface CartItemDao {

//  1.查詢所有購物車明細--成功
	List<CartItem> findAllCartItems();
	
//  2.增加購物車明細--成功
	int addCartItem(CartItem cartItem);

 // 3.刪除特定購物車中特定課程的項目--
    void removeCartItemByCourse(Integer cartId, Integer courseId);
     
//  4.根據使用者ID查找以結帳獲得的購物 
    List<CartItem> findCartItemsByUserIdAndCheckout(int userId);
    

    

    
}
