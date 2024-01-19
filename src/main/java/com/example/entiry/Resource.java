package com.example.entiry;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resource {
	
	private Integer resourceId; 
	
	private Integer courseId; 
	
	private String link; 
	
	private Date createTime; 
	
	private Date updateTime;
	
	private Integer type;
}
