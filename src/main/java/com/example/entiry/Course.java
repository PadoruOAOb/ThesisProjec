package com.example.entiry;

import com.google.gson.Gson;

public class Course {
   private Integer courseId;  // 課程代號
   private String courseName; // 課程名稱
   private Integer price; // 課程價格
   
   public Course() {
		
	}
   
public Course (Integer courseId, String courseName , Integer price) {
	this.courseId = courseId;
	this.courseName = courseName;
	this.price = price;
	
}

public Integer getCourseId() {
	return courseId;
}

public void setCourseId(Integer courseId) {
	this.courseId = courseId;
}

public String getCourseName() {
	return courseName;
}

public void setCourseName(String courseName) {
	this.courseName = courseName;
}

public Integer getPrice() {
	return price;
}

public void setPrice(Integer price) {
	this.price = price;
}

@Override
public String toString() {
	return new Gson().toJson(this);
}
}
