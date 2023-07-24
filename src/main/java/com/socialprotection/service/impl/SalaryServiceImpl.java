package com.socialprotection.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialprotection.repository.SalaryRepository;
import com.socialprotection.service.SalaryService;

@Service
public class SalaryServiceImpl implements SalaryService{
	@Autowired
	private SalaryRepository salaryRepository;
}
