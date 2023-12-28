package com.example.entiry;

public class Course {
   private Integer courseId;  // 商品代號
   private String courseName; // 商品名稱
   private Integer price; // 商品價格
   
   public Course() {
		
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
	return "Course [courseId=" + courseId + ", courseName=" + courseName + ", price=" + price + "]";
}
}
