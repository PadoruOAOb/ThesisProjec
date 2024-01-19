package com.example.dao;

import java.util.List;

import com.example.entiry.Cart;

public interface CartDao {

	List<Cart> findAllCarts();
}
