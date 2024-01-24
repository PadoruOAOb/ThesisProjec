package com.example.entiry;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
	
	private Integer cartId;
	
	private Integer userId;
		
	private Integer isCheckout;
	
	private Date checkoutTime;
	
	private Integer amount;
	
	
	private User user;	
	
	private List<CartItem> cartItems; // 購物車明細(關聯欄位)
	
}
