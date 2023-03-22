package com.sms.io.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sms.io.model.Student;
import com.sms.io.service.StudentService;

@CrossOrigin("*")
@RestController
public class StudentController {
	@Autowired
	StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@PostMapping("/add")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);

	}

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int studentId) {
		return new ResponseEntity<Student>(studentService.getStudentById(studentId), HttpStatus.OK);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") int studentId, @RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.updateStudent(studentId, student), HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
		studentService.deleteStudent(studentId);
		return new ResponseEntity<String>("Student Deleted Successfully", HttpStatus.OK);

	}

}
