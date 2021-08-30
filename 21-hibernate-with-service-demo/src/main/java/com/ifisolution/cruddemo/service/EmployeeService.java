package com.ifisolution.cruddemo.service;

import java.util.List;

import com.ifisolution.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int id);

	public void save(Employee employee);

	public void deleteById(int id);

}
