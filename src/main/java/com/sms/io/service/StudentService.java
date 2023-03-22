package com.sms.io.service;

import java.util.List;

import com.sms.io.model.Student;

public interface StudentService {
	Student saveStudent(Student student);

	List<Student> getAllStudents();

	Student getStudentById(int studentId);

	Student updateStudent(int studentId, Student student);

	void deleteStudent(int studentId);

}
