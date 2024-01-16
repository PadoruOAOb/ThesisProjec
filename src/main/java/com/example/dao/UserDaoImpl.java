package com.example.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.entiry.Service;
import com.example.entiry.User;



@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
//	1. 查詢所有使用者(多筆)
	@Override
	public List<User> findAllUser() {
		String sql = "select userId, username, password, email,level, authType, authId from user";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));
	}
//	2. 新增使用者
	@Override
	public void addUser(User user) {
	    String sql = "insert into user(username, password,email, authType, authId) values(?, ?, ?, ?,?)";
	    jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getAuthType(), user.getAuthId());
	}

//	3. 根據使用者名稱查找使用者(登入用-單筆)	
	@Override
	public Optional<User> findUserByUsername(String username) {
		String sql = "select userId, username, password, level, authType, authId from user where username = ?";
		try {
			User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
			// 查找使用者可以使用的服務(授權)
			String sql2 = "select s.serviceId, s.serviceLocation, s.serviceName, s.serviceUrl "
						+ "from level_ref_service r "
						+ "left join service s on s.serviceId = r.serviceId "
						+ "where r.levelId = ? order by r.sort";
			List<Service> services = jdbcTemplate.query(sql2, new BeanPropertyRowMapper<>(Service.class), user.getLevel());
			user.setServices(services);
			return Optional.ofNullable(user);
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
		
	}
//	4. 修改密碼
	@Override
	public Boolean updateUserPassword(Integer userId, String newPassword) {
		String sql = "update user set password = ? where userId = ?";
		int rowcount = jdbcTemplate.update(sql, newPassword, userId);
		return rowcount > 0;
	}



}
