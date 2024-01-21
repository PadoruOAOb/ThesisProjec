package com.example.dao;

import java.util.List;

import com.example.entiry.Course;

public interface CourseDao {
	// 根據課程ID查詢課程
    Course getCourseById(int courseId);

    // 查詢所有課程
    List<Course> getAllCourses();

    // 添加新課程
    void addCourse(Course course);

    // 更新課程信息
    void updateCourse(Course course);

    // 刪除課程
    void deleteCourse(int courseId);
}
