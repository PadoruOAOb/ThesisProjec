package com.example.entiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
	
	private Integer cartItemId;
	
	private Integer cartId;
	
	private Integer courseId;
	
	private Integer price;
	
	private Integer qty;
}
