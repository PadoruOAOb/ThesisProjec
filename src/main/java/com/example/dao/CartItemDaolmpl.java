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
import com.example.entiry.Course;


@Repository
public class CartItemDaolmpl implements CartItemDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	CourseDao courseDao;

	RowMapper<CartItem> rowMapper = (ResultSet rs, int rowNum) -> {
		CartItem cartItem = new CartItem();
		cartItem.setCartId(rs.getInt("cartId"));
		cartItem.setCartItemId(rs.getInt("cartItemId"));
		cartItem.setCourseId(rs.getInt("courseId"));
		cartItem.setPrice(rs.getInt("price"));
		cartItem.setQty(rs.getInt("qty"));
		int courseId = rs.getInt("courseId");
		Course course = courseDao.findCourseByCourseId(courseId).get();
		cartItem.setCourse(course);
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
	public void removeCartItemByCourse(Integer cartId, Integer courseId) {
		String sql = "DELETE FROM cartItems WHERE cartId = ? AND courseId = ?";
		jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public List<CartItem> findCartItemsByUserIdAndCheckout(int userId) {
		String sql = "SELECT * FROM cartItem JOIN cart ON cartItem.cartId = cart.cartId WHERE userId = 1 AND isCheckout = 1;";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public List<CartItem> findCartItemsByCartId(Integer cartId) {
		String sql = "SELECT cartItemId, cartId, courseId, price, qty FROM cartitem where cartId=?";
		return jdbcTemplate.query(sql, rowMapper,cartId);
	}
	
 
}
