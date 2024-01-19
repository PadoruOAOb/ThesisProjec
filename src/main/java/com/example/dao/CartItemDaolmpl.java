package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

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
}
