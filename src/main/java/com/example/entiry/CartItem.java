package com.example.entiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"cart"})
public class CartItem {
	
	private Integer cartItemId;
	
	private Integer cartId;
	
	private Integer courseId;
	
	private Integer price;
	
	private Integer qty;
	
	private Cart cart; // 購物車物件(關聯欄位)
	
	private Course course; // 商品物件(關聯欄位)
	
	private Type type;
}
