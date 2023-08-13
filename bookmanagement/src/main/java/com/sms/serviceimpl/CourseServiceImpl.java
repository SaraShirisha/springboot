package com.sms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sms.dto.CourseDTO;
import com.sms.entity.Course;
import com.sms.repository.CourseRepository;
import com.sms.repository.StudentRepository;
import com.sms.service.CourseService;
import com.sms.util.CourseConverter;
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	CourseConverter courseConverter;
	@Autowired
	StudentRepository studentRepository;
	@Override
	public CourseDTO addCourse(Course course) {
		Course crs=courseRepository.save(course);	
		
		return courseConverter.convertToCourseDTO(crs);
	}

	@Override
	public List<CourseDTO> getAllcourses() {
		List<Course> courses=courseRepository.findAll();

		//list of DTO type
		List<CourseDTO> dtoList=new ArrayList<>();

		for(Course c:courses)
		{
			dtoList.add(courseConverter.convertToCourseDTO(c));
		}
		return dtoList;
		}
		
		
	@Override
	public CourseDTO getCourseById(int id) {
		Course course=courseRepository.findById(id).get();	
		return courseConverter.convertToCourseDTO(course);
	}

	@Override
	public CourseDTO updateCourse(int id, Course course) {
		Course c=courseRepository.findById(id).get();
		c.setName(course.getName());
		c.setCategory(course.getCategory());
		Course crs=courseRepository.save(c);
		return courseConverter.convertToCourseDTO(crs);
	}

	@Override
	public String deleteCourse(int id) {
		courseRepository.deleteById(id);
		return "Course details got deleted successfully";
	}

	
	@Override
	public List<CourseDTO> getcourseBycategory(String category) {
		
		return courseRepository.findByCategory(category);
	}
	@Override
	public List<CourseDTO> getcourseByName(String name) {
		
		return courseRepository.findByName(name);
	}
	

}