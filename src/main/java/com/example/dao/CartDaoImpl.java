package com.example.dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.entiry.Cart;
import com.example.entiry.User;

/**
 * cartId, userId, amount, isCheckOut, checkOutTime
 */
@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	UserDao userDao;
	
	RowMapper<Cart> rowMapper = (ResultSet rs, int rowNum) -> {
		Cart cart = new Cart();
		cart.setCartId(rs.getInt("cartId"));
		User user = userDao.findUserByUserId(rs.getInt("userId")).get();
		cart.setUser(user);
		cart.setAmount(rs.getInt("amount"));
		cart.setIsCheckout(rs.getInt("isCheckOut"));
		cart.setCheckoutTime(rs.getDate("checkOutTime"));
		return cart; 
	};
	
	@Override
	public List<Cart> findAllCarts() {
		String sql = "SELECT cartId, userId, amount, isCheckOut, checkOutTime FROM cart";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Optional<Cart> findNoneCheckoutCartByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
