package com.example.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.entiry.CartItem;


@Repository
public class CartItemDaolmpl implements CartItemDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	RowMapper<CartItem> rowMapper = (ResultSet rs, int rowNum) -> {
		CartItem cartItem = new CartItem();
		cartItem.setCartId(rs.getInt("cartId"));
		cartItem.setCartItemId(rs.getInt("cartItemId"));
		cartItem.setCourseId(rs.getInt("courseId"));
		cartItem.setPrice(rs.getInt("price"));
		cartItem.setQty(rs.getInt("qty"));
		return cartItem;
	};

	@Override
	public List<CartItem> findAllCartItems() {
		String sql = "SELECT cartItemId, cartId, courseId, price, qty FROM cartitem;";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public void addCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addCartItem'");
	}

	@Override
	public void updateCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateCartItem'");
	}

	@Override
	public void deleteCartItem(int cartItemId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteCartItem'");
	}

	@Override
	public CartItem getCartItemById(Integer cartItemId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getCartItemById'");
	}

	@Override
	public CartItem getCartItemByCourse(Integer cartId, Integer courseId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getCartItemByCourse'");
	}

	@Override
	public void updateCartItemQuantity(Integer cartItemId, Integer newQuantity) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateCartItemQuantity'");
	}

	@Override
	public void deleteCartItemByCourse(Integer cartId, Integer courseId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteCartItemByCourse'");
	}
}
