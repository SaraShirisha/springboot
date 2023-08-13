package com.sms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import com.sms.dto.StudentDTO;
import com.sms.entity.Student;
import com.sms.exception.ResourceNotFoundException;
import com.sms.service.StudentService;

@RestController
	
	public class StudentController {
	@Autowired
	StudentService studentService;
	
	@PostMapping("/addStudent")
	ResponseEntity<Student> addStudent(@RequestBody @Valid StudentDTO studentDTO)
	{ 
		
		try {
			Student student=studentService.addStudent(studentDTO);
			if(student!=null) {
				return new ResponseEntity<Student>(student,HttpStatus.CREATED);
			}
		}
		catch(Exception e) {
			throw new ResourceNotFoundException("check student data is not entered properly");
		}
		return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getStudentById/{id}")
	ResponseEntity<StudentDTO> getStudentById(@PathVariable int id)
	{
		return new ResponseEntity<StudentDTO>(studentService.getStudentById(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/getAllStudent")
	ResponseEntity<List<StudentDTO>> getStudents()
	{
		return new ResponseEntity<List<StudentDTO>>(studentService.getAllStudents(),HttpStatus.FOUND);
	}
	
	@GetMapping("/getstudentbyAddress")
	ResponseEntity<Student> getStudentByPrice(@PathVariable String address){
	
		return new ResponseEntity<Student>(HttpStatus.OK);
	}
	@GetMapping("/getStudentbyname")
	ResponseEntity<Student> getStudentByName(@PathVariable String name){
		return new ResponseEntity<Student>(HttpStatus.OK);
	}

}

	
