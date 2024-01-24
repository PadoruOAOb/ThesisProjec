package com.example.dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.entiry.Resource;

@Repository
public class ResourceDaoImpl implements ResourceDao{
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	RowMapper<Resource> rowMapper = (ResultSet rs, int rowNum) -> {
		Resource resourcer = new Resource();
		resourcer.setResourceId(rs.getInt("resourceId"));
		resourcer.setCourseId(rs.getInt("courseId"));
		resourcer.setLink(rs.getString("link"));
		resourcer.setCreateTime(rs.getDate("createTime"));
		resourcer.setUpdateTime(rs.getDate("updateTime"));
		resourcer.setType(rs.getInt("type"));
		return resourcer;
	};
	
	
	@Override
	public int updateLink(String link, Integer resourceId) {
		String sql = "update resource set link=? where userId=?";
		return jdbcTemplate.update(sql, link, resourceId);
		
	}

	@Override
	public Optional<Resource> findLinkByResourceId(Integer resourceId) {
		String sql = "SELECT resourceId, courseId, link, createTime, updateTime, type where resourceId=?";
		try {
			Resource resource= jdbcTemplate.queryForObject(sql, rowMapper,resourceId);
			return Optional.of(resource);
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	@Override
	public List<Resource> findAllResourcesByCourseId(Integer courseId) {
		String sql = "SELECT resourceId, courseId, link, createTime, updateTime, type FROM resource where courseId = ?";
		return jdbcTemplate.query(sql, rowMapper,courseId);
	}

}
