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
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.entiry.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	RowMapper<User> rowMapper = (ResultSet rs, int rowNum) -> {
		User user = new User();
		user.setUserId(rs.getInt("userId"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		user.setLevel(rs.getInt("level"));
		user.setAuthType(rs.getString("authType"));
		user.setAuthId(rs.getString("authId"));
		return user; 
	};
	
	@Override
	public List<User> findAllUsers() {
		String sql = "SELECT userId, username, password, email, level, authType, authId FROM user";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Optional<User> findUserByUsername(String username) {
		String sql = "SELECT userId, username, password, email, level, authType, authId FROM user where username=?";
		try {
			User user = jdbcTemplate.queryForObject(sql, rowMapper,username);
			return Optional.of(user);
		} catch (Exception e) {
			return Optional.empty();
		}
	}
	
	@Override
	public Optional<User> findUserByUserId(Integer userId) {
		String sql = "SELECT userId, username, password, email, level, authType, authId FROM user where userId=?";
		try {
			User user = jdbcTemplate.queryForObject(sql, rowMapper,userId);
			return Optional.of(user);
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	@Override
	public int addUser(User user) {
		
		String sql = "insert into user(username, password, email) values (?,?,?) ";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		int rowsAffected = jdbcTemplate.update(
				(Connection connection) -> {
					PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, user.getUsername());
					ps.setString(2, user.getPassword());
					ps.setString(3, user.getEmail());
					return ps;
				}, keyHolder);

		if (rowsAffected > 0) {
			user.setUserId(keyHolder.getKey().intValue());
		}

		return rowsAffected;
	}

	@Override
	public int updateUserPassword(String password,Integer userId) {
		String sql = "update user set password=? where userId=?";
		return jdbcTemplate.update(sql, password,userId);
	}

	@Override
	public int removeUser(Integer userId) {
		String sql = "delete user where userId=?";
		return jdbcTemplate.update(sql,userId);
	}
}
