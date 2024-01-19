package com.example.dao;

import java.util.List;
import java.util.Optional;

import com.example.entiry.Cart;

public interface CartDao {

	List<Cart> findAllCarts();
	
//	8. 根據使用者ID來查找其未結帳的購物車資料(單筆)
	Optional<Cart> findNoneCheckoutCartByUserId(Integer userId);
}
