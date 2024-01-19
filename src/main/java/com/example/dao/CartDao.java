package com.example.dao;

import java.util.List;
import java.util.Optional;

import com.example.entiry.Cart;
import com.example.entiry.CartItem;

public interface CartDao {

	List<Cart> findAllCarts();

	void addCartItem(CartItem cartItem);

	void updateCartItem(CartItem cartItem);

	void deleteCartItem(int cartItemId);

    CartItem getCartItemById(Integer cartItemId);

    // 獲取特定購物車中的特定課程項目
    CartItem getCartItemByCourse(Integer cartId, Integer courseId);

    // 更新特定購物車中特定課程的數量
    void updateCartItemQuantity(Integer cartItemId, Integer newQuantity);

    // 刪除特定購物車中特定課程的項目
    void deleteCartItemByCourse(Integer cartId, Integer courseId);

    Optional<Cart> findNoneCheckoutCartByUserId(Integer userId);
}