package com.example.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.entiry.CartItem;
import com.example.entiry.Course;
import com.example.entiry.Type;


@Repository
public class TypeDaoImpl implements TypeDao {
	
	@Autowired JdbcTemplate jdbcTemplate;

	RowMapper<Type> rowMapper=(ResultSet rs,int rowNum)->{
		Type type=new Type();
		type.setTypeId(rs.getInt("typeId"));
		type.setTypeName(rs.getString("typeName"));
		return type;
	};

	@Override
	public List<Course> findCourseByTypeId(Integer typeId) {
	    String sql = "SELECT * FROM course WHERE typeId = ?";
	    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Course.class), typeId);
	}





}
