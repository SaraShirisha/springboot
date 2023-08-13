package com.sms.serviceimpl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.dto.StudentDTO;
import com.sms.entity.Student;
import com.sms.repository.CourseRepository;
import com.sms.repository.StudentRepository;
import com.sms.service.StudentService;
import com.sms.util.StudentConverter;

@Service
public  class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	StudentConverter studentConverter;
	@Autowired
	CourseRepository courseRepository;
	@Override
	public StudentDTO addStudent(Student student) {
		Student s=studentRepository.save(student);
		return studentConverter.convertToStudentDTO(s);
	}
	@Override
	public List<StudentDTO> getAllStudents() {
		List<Student>students=studentRepository.findAll();
		List<StudentDTO>dtoList=new ArrayList<>();
		for(Student s:students)
		{
			dtoList.add(studentConverter.convertToStudentDTO(s));
		}
		return dtoList;
	}
	@Override
	public StudentDTO getStudentById(int id) {
		Student student=studentRepository.findById(id).get();
		return studentConverter.convertToStudentDTO(student);
	}
	@Override
	public String deleteStudent(int id) {
		studentRepository.deleteById(id);
		return "Student details got deleted successfuly";
	}
	
	@Override
	public List<StudentDTO> getstudentByAddress(String address) {
		
		return studentRepository.findByAddress(address);
	}
	
	
	@Override
	public List<StudentDTO> getstudentByName(String name) {
		
		return  studentRepository.findByName(name);
	}

	
	@Override
	public Student addStudent(StudentDTO studentDTO) {
		Student student=Student.builder()
				.id(studentDTO.getId())
				.name(studentDTO.getName())
				.address(studentDTO.getAddress())
				.build();
		return studentRepository.save(student);
	}
	
	
	}
	
	
	
	

	