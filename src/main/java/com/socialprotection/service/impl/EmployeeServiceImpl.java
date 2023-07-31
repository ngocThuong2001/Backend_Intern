package com.socialprotection.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialprotection.repository.EmployeeRepository;
import com.socialprotection.repository.JobRepository;
import com.socialprotection.repository.ShiftRepository;
import com.socialprotection.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired 
	private JobRepository jobRepository;
	@Autowired
	private ShiftRepository shiftRepository;
	
	
}
