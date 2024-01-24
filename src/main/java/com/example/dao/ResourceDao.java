package com.example.dao;

import java.util.List;
import java.util.Optional;

import com.example.entiry.Resource;
import com.example.entiry.User;

public interface ResourceDao {

	int updateLink(String link,Integer resourceId);
	
	Optional<Resource> findLinkByResourceId(Integer resourceId);
	
	List<Resource> findAllResourcesByCourseId(Integer courseId);
}
