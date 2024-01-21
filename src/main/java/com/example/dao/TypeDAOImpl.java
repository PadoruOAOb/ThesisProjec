package com.example.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.entiry.CartItem;
import com.example.entiry.Type;

Integer typeId;

String typeName;

@Repository
public class TypeDAOImpl implements TypeDao {

	RowMapper<Type> rowMapper=(ResultSet rs,int rowNum)->{
		Type type=new Type();
		type.typeId(rs.getInt("typeId"));
		type.settypeName(rs.getString("typeName"));
		return type;
	}

	@Autowired JdbcTemplate jdbcTemplate;

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
