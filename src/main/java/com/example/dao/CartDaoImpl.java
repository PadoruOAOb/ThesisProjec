package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.entiry.Cart;
import com.example.entiry.CartItem;
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
	public int addCart(Cart cart) {
		String sql = "insert into cart(userId, amount, isCheckOut)  values (?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		int rowsAffected = jdbcTemplate.update((Connection connection) -> {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, cart.getUserId());
			ps.setInt(2, cart.getAmount());
			ps.setInt(3, cart.getIsCheckout());
			return ps;
		}, keyHolder);

		if (rowsAffected > 0) {
			cart.setCartId(keyHolder.getKey().intValue());
		}

		return rowsAffected;

	}
	
	@Override
	public List<Cart> findCartsbyUserIdAndCheckoutStatus(Integer userId, Integer isCheckout) {
		String sql = "select cartId, userId, isCheckout, checkoutTime from cart where userId = ? and isCheckout = ?";
		List<Cart> carts = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cart.class), userId, isCheckout);
		return carts;
	}
}

