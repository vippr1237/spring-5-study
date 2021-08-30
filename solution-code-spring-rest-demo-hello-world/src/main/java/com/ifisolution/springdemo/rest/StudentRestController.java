package com.ifisolution.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifisolution.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

	public StudentRestController() {
		students = new ArrayList<>();
		students.add(new Student("Huy", "Trinh"));
		students.add(new Student("Ha", "Coang"));
		students.add(new Student("Minh", "Duc"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		if (studentId >= students.size() || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found -" + studentId);
		}

		return students.get(studentId);

	}

	// Add exception handler

}
