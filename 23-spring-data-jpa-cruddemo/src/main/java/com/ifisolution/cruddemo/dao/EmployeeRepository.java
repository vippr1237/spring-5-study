package com.ifisolution.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifisolution.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
