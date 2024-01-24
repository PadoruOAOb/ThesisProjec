package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.entiry.Course;
import com.example.entiry.Resource;
import com.example.entiry.User;

/**
 * courseId,courseName,price,courseDescription,
 * courseDetail,courseImg,teacher,typeId,createTime;
 * 
 */
@Repository
public class CourseDaoImpl implements CourseDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	ResourceDao resourceDao;

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
		List<Resource> resources = resourceDao.findAllResourcesByCourseId(rs.getInt("courseId"));
		course.setResoruces(resources);
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

	@Override
	public int findCoursePriceByName(String courseName) {
		String sql = "SELECT price FROM course WHERE courseName = ?";
		try {
			// 打印 SQL 查询语句和查询参数
			System.out.println("Executing SQL query: " + sql);
			System.out.println("Query parameter - courseName: " + courseName);

			// 使用 queryForObject 來檢索單一值
			Integer price = jdbcTemplate.queryForObject(sql, Integer.class, courseName);

			// 如果 price 為 null，表示找不到資料，可以返回一個預設值或者拋出異常，視情況而定
			return (price != null) ? price : 0; // 這裡假設價格的預設值為 0
		} catch (EmptyResultDataAccessException e) {
			// 如果找不到資料，可以返回一個預設值或者拋出異常，視情況而定
			System.out.println("找不到课程：" + courseName);
			return 0; // 這裡假設價格的預設值為 0
		}
	}

	@Override
	public int findCoursePriceById(int courseId) {
		String sql = "SELECT price FROM course WHERE courseId = ?";
		try {
			// 打印 SQL 查询语句和查询参数
			System.out.println("Executing SQL query: " + sql);
			System.out.println("Query parameter - courseName: " + courseId);

			// 使用 queryForObject 來檢索單一值
			Integer price = jdbcTemplate.queryForObject(sql, Integer.class, courseId);

			// 如果 price 為 null，表示找不到資料，可以返回一個預設值或者拋出異常，視情況而定
			return (price != null) ? price : 0; // 這裡假設價格的預設值為 0
		} catch (EmptyResultDataAccessException e) {
			// 如果找不到資料，可以返回一個預設值或者拋出異常，視情況而定
			System.out.println("找不到课程：" + courseId);
			return 0; // 這裡假設價格的預設值為 0
		}
	}

	@Override
	public Optional<Course> findCourseByCourseId(Integer courseId) {
		String sql = "SELECT courseId, courseName, courseDescription, courseDetail, courseImg, teacher, price, typeId, createTime FROM course where courseId=?";
		return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Course.class),courseId));
	}
}
