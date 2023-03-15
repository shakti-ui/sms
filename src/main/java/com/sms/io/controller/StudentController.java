package com.sms.io.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.io.dto.StudentDTO;
import com.sms.io.service.StudentService;

@RestController
@RequestMapping(path = "/v1/student")
public class StudentController {
	@Autowired
	StudentService studentService;

	@PostMapping(path = "/create")
	public AppResponse create(@RequestBody StudentDTO studentDTO) {
		studentService.save(studentDTO);
		AppResponse appResponse = new AppResponse();
		appResponse.setMessage("student data inserted successfully");
		return appResponse;

	}

	@GetMapping(path = "/getAll")
	public AppResponse getAllStudent() {
		List<StudentDTO> getAll = studentService.getAll();
		AppResponse appResponse = new AppResponse();
		appResponse.setMessage("student data fetched successfully" + getAll);
		return appResponse;

	}

	@GetMapping(path = "/{studentId}")
	public StudentDTO getStudentById(@PathVariable Integer studentId) {
		StudentDTO studentDTO = studentService.findById(studentId);
		return studentDTO;
	}

	@DeleteMapping(path = "/{studentId}")
	public AppResponse deleteStudentById(@PathVariable("studentId") Integer studentId) {
		studentService.deleteById(studentId);
		AppResponse appResponse = new AppResponse();
		appResponse.setMessage("student Id" + studentId + "deleted from database");
		return appResponse;
	}

	@PutMapping(path = "/{studentId}")
	public AppResponse updateStudent(@RequestBody StudentDTO studentDTO) {
		studentService.update(studentDTO);
		AppResponse appResponse = new AppResponse();
		appResponse.setMessage("Updated successfully.");
		return appResponse;

	}
}
