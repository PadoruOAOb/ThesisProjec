package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
//	1. 查詢所有商品(多筆)測試成功
	@Override
	public List<Cart> findAllCarts() {
		String sql = "SELECT cartId, userId, amount, isCheckOut, checkOutTime FROM cart";
		return jdbcTemplate.query(sql, rowMapper);
	}
//	2. 新增購物車資料
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
	
//	3. 根據購物車ID查找購物車資料(單筆)
    @Override
	public Optional<Cart> findCartById(Integer cartId) {
	    try {
	        String sql = "select cartId, userId, isCheckout, checkoutTime from cart where userId = ? and isCheckout = ?";
	        Cart cart = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Cart.class), cartId);
	        return Optional.ofNullable(cart);
	    } catch (EmptyResultDataAccessException e) {
	        return Optional.empty();
	    }
	}
    
//	4. 根據使用者ID及結帳狀態來查找其所有購物車資料(多筆)
	@Override
	public List<Cart> findCartsbyUserIdAndCheckoutStatus(Integer userId, Integer isCheckout) {
		String sql = "select cartId, userId, isCheckout, checkoutTime from cart where userId = ? and isCheckout = 0";
		List<Cart> carts = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cart.class), userId, isCheckout);
		return carts;
	}

//	5. 根據使用者ID來查找其未結帳的購物車資料(單筆)
	@Override
	public Optional<Cart> findNoneCheckoutCartByUserId(Integer userId) {
		try {
			String sql = "select cartId, userId, isCheckout, checkoutTime from cart "
					+ "where userId = ? and (isCheckout = 0 or isCheckout is null)";
			Cart cart = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Cart.class), userId);
			if(cart != null) {
//				enrichCartWithDetails(cart);
			}
			return Optional.ofNullable(cart);
		
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}
	
//	6.根據使用者ID將該使用者的購物車設置為已結帳狀態(前台的事件)
	@Override
	public int checkoutCartByUserId(Integer userId) {
		String sql = "update cart set isCheckout = true where userId = ? and (isCheckout = false or isCheckout is null)";
		return jdbcTemplate.update(sql, userId);
	}
	
//	7. 根據購物車ID將購物車設置為已結帳狀態(後台的事件)
	@Override
	public int checkoutCartById(Integer cartId) {
		String sql = "update cart set isCheckout = true where cartId = ? and (isCheckout = false or isCheckout is null)";
		return jdbcTemplate.update(sql, cartId);
	}
}



