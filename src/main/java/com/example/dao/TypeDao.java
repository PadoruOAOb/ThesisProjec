package com.example.dao;

import java.util.List;

import com.example.entiry.Course;
import com.example.entiry.Type;

public interface TypeDao {
	
//	1根據課程類別來尋找課程--成功
	List<Course> findCourseByTypeId(Integer typeId);

    
    
}
