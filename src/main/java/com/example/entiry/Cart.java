package com.example.entiry;

import java.util.Date;
import java.util.List;

import com.example.entiry.CartItem;
import com.example.entiry.User;

public class Cart {
	private Integer cartId; // 購物車 Id
	private Integer userId; // 使用者 Id
	private Boolean isCheckout; // 是否結帳
	private Date checkoutTime; // 結帳時間
	
	private User user; // 使用者物件(關聯欄位)
	private List<CartItem> cartItems; // 購物車明細(關聯欄位)
	
	public Cart() {
		
	}
	
	public Cart(Integer cartId, Integer userId, Boolean isCheckout, Date checkoutTime) {
		this.cartId = cartId;
		this.userId = userId;
		this.checkoutTime = checkoutTime;
		setIsCheckout(isCheckout);
		
	}
	
	public Cart(Integer cartId, Integer userId, List<CartItem> cartItems, Boolean isCheckout) {
		this.cartId = cartId;
		this.userId = userId;
		this.cartItems = cartItems;
		
		setIsCheckout(isCheckout);
		
		// 根據 userId 找到 User 物件
		
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

	public Boolean getIsCheckout() {
		return isCheckout;
	}

	public void setIsCheckout(Boolean isCheckout) {
		this.isCheckout = isCheckout;
		if(isCheckout != null && isCheckout) {
			setCheckoutTime(new Date());
		}
	}

	public Date getCheckoutTime() {
		return checkoutTime;
	}

	private void setCheckoutTime(Date checkoutTime) {
		this.checkoutTime = checkoutTime;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", user=" + user + ", cartItems=" + cartItems
				+ ", isCheckout=" + isCheckout + ", checkoutTime=" + checkoutTime + "]";
	}
	
	
	
	
	
}
