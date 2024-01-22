package com.example.dao;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
	public Course getCourseById(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		
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
