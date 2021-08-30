package com.solution.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.solution.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> employees;

	@PostConstruct
	private void loadData() {
		employees = new ArrayList<>();

		employees.add(new Employee(1, "Huy", "Trinh", "HuyTrinh@gmail.com"));
		employees.add(new Employee(2, "Ha", "Coang", "hacoang@gmail.com"));
		employees.add(new Employee(3, "Minh", "Duc", "minhduc@gmail.com"));
	}

	@GetMapping("/list")
	public String listEmployee(Model model) {
		model.addAttribute("employees", employees);

		return "list-employees";
	}
}
