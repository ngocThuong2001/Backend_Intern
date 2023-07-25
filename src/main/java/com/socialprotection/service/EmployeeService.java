package com.socialprotection.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.socialprotection.entity.Employee;
import com.socialprotection.repository.EmployeeRepository;

public interface EmployeeService {
	Employee save(Employee employee);
	List<Employee> findAll();
	Employee findById(long id);
}
