package com.sms.io.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.io.dto.StudentDTO;
import com.sms.io.model.Student;
import com.sms.io.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;

//	public void save(StudentDTO studentDTO) {
//		Student student = new Student();
//		BeanUtils.copyProperties(studentDTO, student);
//
//		studentRepository.save(student);
//
//	}

	public List<Student> getAll() {
		return (List<Student>) studentRepository.findAll();

	}

//	public List<StudentDTO> getAll() {
//		List<StudentDTO> studentDTOs = new ArrayList<StudentDTO>();
//		List<Student> students = studentRepository.findAll();
//		System.out.println(students);
//		for (Student student : students) {
//			StudentDTO studentDTO = new StudentDTO();
//			BeanUtils.copyProperties(student, studentDTO);
//			studentDTOs.add(studentDTO);
//		}
//		return studentDTOs;
//	}

	public StudentDTO findById(Integer studentId) {
		Optional<Student> optional = studentRepository.findById(studentId);
		if (optional.isPresent()) {
			StudentDTO studentDTO = new StudentDTO();
			BeanUtils.copyProperties(optional.get(), studentDTO);
			return studentDTO;
		} else {
			throw new EntityNotFoundException("Sorry this record " + studentId + " could not found in database");
		}

	}

	public void deleteById(Integer studentId) {
		studentRepository.deleteById(studentId);

	}

	public void updateById(Integer studentId) {
		Student student = new Student();

		System.out.println(student);
		studentRepository.save(student);

	}

	public void update(StudentDTO studentDTO) {
		Student optional = studentRepository.findById(studentDTO.getSid()).get();
		optional.setPhoneNumber(studentDTO.getPhoneNumber());
		optional.setFirstName(studentDTO.getFirstName());

		studentRepository.save(optional);

	}

	public void save(Student student) {
		studentRepository.save(student);
		// TODO Auto-generated method stub

	}

}
