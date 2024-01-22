package com.example.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.entiry.CartItem;
import com.example.entiry.Type;


@Repository
public class TypeDAOImpl implements TypeDao {
	
	@Autowired JdbcTemplate jdbcTemplate;

	RowMapper<Type> rowMapper=(ResultSet rs,int rowNum)->{
		Type type=new Type();
		type.setTypeId(rs.getInt("typeId"));
		type.setTypeName(rs.getString("typeName"));
		return type;
	};



	@Override public void updateType(Type type)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteType(Integer typeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Type getTypeById(Integer typeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Type> getAllTypes() {
		// TODO Auto-generated method stub
		return null;
	}
}
