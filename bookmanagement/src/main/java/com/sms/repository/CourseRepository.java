package com.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.dto.CourseDTO;
import com.sms.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	List<CourseDTO> findByCategory(String category);  
	List<CourseDTO> findByName(String coursename);

}
