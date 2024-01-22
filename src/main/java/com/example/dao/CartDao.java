package com.example.dao;

import java.util.List;
import java.util.Optional;

import com.example.entiry.Cart;
import com.example.entiry.CartItem;
import com.example.entiry.User;

public interface CartDao {

	List<Cart> findAllCarts();
    
	int addCart(Cart cart);

	List<Cart> findCartsbyUserIdAndCheckoutStatus(Integer userId, Integer isCheckout);
}