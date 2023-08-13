package com.sms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.sms.dto.StudentDTO;
import com.sms.entity.Student;
@Component
public class StudentConverter {
	//converting DTO to entity
	Student convertToStudentEntity(StudentDTO StudentDTO)
	{
		Student student=new Student();
		if(StudentDTO!=null)
		{
			BeanUtils.copyProperties(StudentDTO, student);
		}
		return student;
		
	}
	//converting  entity to DTO
	public StudentDTO convertToStudentDTO(Student student)
	{
		StudentDTO studentDTO=new StudentDTO();
		if(student!=null)
		{
			BeanUtils.copyProperties(student, studentDTO);
		}
		return studentDTO;
		
	}
}