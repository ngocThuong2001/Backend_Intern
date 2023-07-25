package com.socialprotection.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.socialprotection.entity.Employee;
import com.socialprotection.repository.EmployeeRepository;

public interface EmployeeService {
	Employee save(Employee employee);
}
