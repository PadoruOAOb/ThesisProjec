package com.example.entiry;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	
	private Integer courseId;
	
	private String courseName;
	
	private Integer price;
	
	private String courseDescription;
	 
	private String courseDetail;
	
	private String courseImg;
	
	private Integer teacher;
	
	private Integer typeId;
	
	private Date createTime;
	
	private List<Resource> resoruces;

    
}
