package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.entiry.Course;
import com.example.entiry.User;


/**
 courseId,courseName,price,courseDescription,
 courseDetail,courseImg,teacher,typeId,createTime;

 */
@Repository
public class CourseDaoImpl implements CourseDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	RowMapper<Course> rowMapper = (ResultSet rs, int rowNum) -> {
		Course course = new Course();
		course.setCourseId(rs.getInt("courseId"));
		course.setCourseName(rs.getString("courseName"));
		course.setPrice(rs.getInt("price"));
		course.setCourseDescription(rs.getString("courseDescription"));
		course.setTeacher(rs.getInt("teacher"));
		course.setCourseDetail(rs.getString("courseDetail"));
		course.setCourseImg(rs.getString("courseImg"));
		course.setTypeId(rs.getInt("typeId"));
		course.setCreateTime(rs.getDate("createTime"));
		return course;
	};
	@Override
	public List<Course> findAllCourses() {
			String sql = "SELECT courseId, courseName, courseDescription, courseDetail, courseImg, teacher, price, typeId, createTime FROM course";
			return jdbcTemplate.query(sql, rowMapper);		
	}
	@Override
	public int addCourse(Course course) {
		String sql = "insert into course (courseName, courseDescription, courseDetail, courseImg, teacher, price, typeId)"
				+ "    values (?,?,?,?,?,?,?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();

		int rowsAffected = jdbcTemplate.update((Connection connection) -> {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, course.getCourseName());
			ps.setString(2, course.getCourseDescription());
			ps.setString(3, course.getCourseDetail());
			ps.setString(4, course.getCourseImg());
			ps.setInt(5, course.getTeacher());
			ps.setInt(6, course.getPrice());
			ps.setInt(7, course.getTypeId());
			
			return ps;
		}, keyHolder);

		if (rowsAffected > 0) {
			course.setCourseId(keyHolder.getKey().intValue());
		}

		return rowsAffected;
	}
		
	
	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteCourse(int courseId) {
		// TODO Auto-generated method stub
		
	}

	
}
