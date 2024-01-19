package com.example.dao;

import java.util.List;

import com.example.entiry.CartItem;

public interface CartItemDao {

	List<CartItem> findAllCartItems();
}
