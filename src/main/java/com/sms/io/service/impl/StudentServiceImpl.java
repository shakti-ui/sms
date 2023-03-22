package com.sms.io.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.io.model.Student;
import com.sms.io.repository.StudentRepository;
import com.sms.io.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);

	}
//	@Autowired
//	StudentRepository studentRepository;
//
////	public void save(StudentDTO studentDTO) {
////		Student student = new Student();
////		BeanUtils.copyProperties(studentDTO, student);
////
////		studentRepository.save(student);
////
////	}
//
//	public List<Student> getAll() {
//		return (List<Student>) studentRepository.findAll();
//
//	}
//
////	public List<StudentDTO> getAll() {
////		List<StudentDTO> studentDTOs = new ArrayList<StudentDTO>();
////		List<Student> students = studentRepository.findAll();
////		System.out.println(students);
////		for (Student student : students) {
////			StudentDTO studentDTO = new StudentDTO();
////			BeanUtils.copyProperties(student, studentDTO);
////			studentDTOs.add(studentDTO);
////		}
////		return studentDTOs;
////	}
//
//	public StudentDTO findById(Integer studentId) {
//		Optional<Student> optional = studentRepository.findById(studentId);
//		if (optional.isPresent()) {
//			StudentDTO studentDTO = new StudentDTO();
//			BeanUtils.copyProperties(optional.get(), studentDTO);
//			return studentDTO;
//		} else {
//			throw new EntityNotFoundException("Sorry this record " + studentId + " could not found in database");
//		}
//
//	}
//
//	public void deleteById(Integer studentId) {
//		studentRepository.deleteById(studentId);
//
//	}
//
//	public void updateById(Integer studentId) {
//		Student student = new Student();
//
//		System.out.println(student);
//		studentRepository.save(student);
//
//	}
//
//	public void update(StudentDTO studentDTO) {
//		Student optional = studentRepository.findById(studentDTO.getSid()).get();
//		optional.setPhoneNumber(studentDTO.getPhoneNumber());
//		optional.setFirstName(studentDTO.getFirstName());
//
//		studentRepository.save(optional);
//
//	}
//
//	public void save(Student student) {
//		studentRepository.save(student);
//		// TODO Auto-generated method stub
//
//	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int studentId) {

		return studentRepository.findById(studentId).orElseThrow(
				() -> new EntityNotFoundException("Sorry this record " + studentId + " could not found in database"));
	}

	@Override
	public Student updateStudent(int studentId, Student student) {
		Student existStudent = studentRepository.findById(studentId).orElseThrow(
				() -> new EntityNotFoundException("Sorry this record " + studentId + " could not found in database"));
		existStudent.setFirstName(student.getFirstName());
		existStudent.setLastName(student.getLastName());
		existStudent.setAddress(student.getAddress());
		existStudent.setPhoneNumber(student.getPhoneNumber());
		existStudent.setEmail(student.getEmail());
		existStudent.setDob(student.getDob());
		studentRepository.save(existStudent);

		return existStudent;
	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.findById(studentId).orElseThrow(
				() -> new EntityNotFoundException("Sorry this record " + studentId + " could not found in database"));
		studentRepository.deleteById(studentId);
	}

}
