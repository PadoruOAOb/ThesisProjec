package com.example.dao;

import java.util.List;

import com.example.entiry.Course;

public interface CourseDao {

    // 查詢所有課程
    List<Course> findAllCourses();

    // 添加新課程
    int addCourse(Course course);

    // 更新課程信息
    void updateCourse(Course course);

    // 刪除課程
    void deleteCourse(int courseId);
    
    //根據課程名子獲取價格
    int findCoursePriceByName(String courseName);
    
    //根據課程ID獲取價格
    int findCoursePriceById(int courseId);
}
