package com.socialprotection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialprotection.entity.Employee;
import com.socialprotection.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok(employee);
	}

}
