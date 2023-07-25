package com.socialprotection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialprotection.entity.Employee;
import com.socialprotection.service.EmployeeService;

@RestController
@RequestMapping("/api'employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.save(employee));
	}
}
