package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.entiry.User;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<User> findAllUser() {
		String sql = "select userId, username, password, email, level from user";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));
	}

}
