package com.sms.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.sms.dto.CourseDTO;
import com.sms.entity.Course;
import com.sms.service.CourseService;
import com.sms.util.CourseConverter;


@RestController
public class CourseController 
{
	@Autowired
	CourseService courseService;
	@Autowired
	CourseConverter courseConverter;
	
	@PostMapping("/addCourse")
	ResponseEntity<CourseDTO> addCourse(@RequestBody @Valid CourseDTO courseDTO)
	{ 
		
		Course course=courseConverter.convertToCourseEntity(courseDTO);
		return new ResponseEntity<CourseDTO>(courseService.addCourse(course),HttpStatus.CREATED);
	}
	
	@GetMapping("/getCourseById/{id}")
	ResponseEntity<CourseDTO> getCourseById(@PathVariable int id)
	{
		return new ResponseEntity<CourseDTO>(courseService.getCourseById(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/getAllCourse")
	ResponseEntity<List<CourseDTO>> getCourses()
	{
		return new ResponseEntity<List<CourseDTO>>(courseService.getAllcourses(),HttpStatus.FOUND);
	}
	
	@PutMapping("/updateCourse/{id}")
	ResponseEntity<CourseDTO> updateCourse(@PathVariable int id,@RequestBody CourseDTO courseDTO)
	{
		Course course=courseConverter.convertToCourseEntity(courseDTO);
		return new ResponseEntity<CourseDTO>(courseService.updateCourse(id, course),HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/deleteCourseById/{id}")
	ResponseEntity<String> deleteCourseById(@PathVariable int id)
	{
		return new ResponseEntity(courseService.deleteCourse(id),HttpStatus.OK);
	}
	
	@GetMapping("/getCoursebycaterogy")
	ResponseEntity<CourseDTO> getCourseBycaterogy(@PathVariable String caterogy){
		return new ResponseEntity<CourseDTO>(HttpStatus.OK);
	}
	@GetMapping("/getCoursebyname")
	ResponseEntity<CourseDTO> getCourseByName(@PathVariable String name){
		return new ResponseEntity<CourseDTO>(HttpStatus.OK);
	}
	
	
}

