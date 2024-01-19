package com.example.entiry;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
	
	private Integer cartId;
	
	//private Integer userId;
	private User user;
	
	private Integer isCheckout;
	
	private Date checkoutTime;
	
	private Integer amount;
}
