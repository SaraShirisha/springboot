package com.sms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sms.dto.CourseDTO;
import com.sms.entity.Course;

@Service
public interface CourseService {
	CourseDTO addCourse(Course course);
	 List<CourseDTO> getAllcourses();
	CourseDTO getCourseById(int id);
	CourseDTO updateCourse(int id, Course course);
	 String deleteCourse(int id);
	 List<CourseDTO> getcourseBycategory(String category);  
	 List<CourseDTO> getcourseByName(String name);
}
