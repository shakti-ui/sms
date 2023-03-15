package com.sms.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.sms.io.controller.AppResponse;
import com.sms.io.dto.StudentDTO;
import com.sms.io.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	ResponseEntity<AppResponse> save(StudentDTO studentDTO);

}
