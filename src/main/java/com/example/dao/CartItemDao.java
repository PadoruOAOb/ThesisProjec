package com.example.dao;

import java.util.List;

import com.example.entiry.CartItem;

public interface CartItemDao {

	List<CartItem> findAllCartItems();

	int addCartItem(CartItem cartItem);

	void updateCartItem(CartItem cartItem);

    // 刪除特定購物車中特定課程的項目
    void deleteCartItemByCourse(Integer cartId, Integer courseId);
}
