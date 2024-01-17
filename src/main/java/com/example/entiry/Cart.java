package com.example.entiry;

import java.util.Date;
import java.util.List;

import spring.mvc.group_buy.model.entity.CartItem;
import spring.mvc.group_buy.model.entity.User;

public class Cart {
	private Integer cartId; // 購物車 Id
	private Integer userId; // 使用者 Id
	private List<CartItem> items;
	
	private User user; // 使用者物件(關聯欄位)
	private List<CartItem> cartItems; // 購物車明細(關聯欄位)
	
	public Cart() {
		
	}
	
	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public Cart(Integer cartId, Integer userId) {
		this.cartId = cartId;
		this.userId = userId;

		
	}
	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", items=" + items + ", user=" + user + ", cartItems="
				+ cartItems + "]";
	}


	
}
