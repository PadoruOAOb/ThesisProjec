package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
	public int addCartItem(CartItem cartItem) {
		String sql = "insert into cartItem(cartId, courseId, price) values (?,?,?) ";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();

		int rowsAffected = jdbcTemplate.update((Connection connection) -> {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, cartItem.getCartId());
			ps.setInt(2, cartItem.getCourseId());
			ps.setInt(3, cartItem.getPrice());
			return ps;
		}, keyHolder);

		if (rowsAffected > 0) {
			cartItem.setCartItemId(keyHolder.getKey().intValue());
		}

		return rowsAffected;
	}

	@Override
	public void deleteCartItemByCourse(Integer cartId, Integer courseId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteCartItemByCourse'");
	}

	@Override
	public List<CartItem> findCartItemsByUserIdAndCheckout(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
    @Override
	public List<Map<String, Object>> calculateTotalAmountPerUser() {
	    String sql = "SELECT userId, SUM(amount) as totalAmount FROM cart WHERE isCheckout = true GROUP BY userId";
	    return jdbcTemplate.queryForList(sql);
	}
}
