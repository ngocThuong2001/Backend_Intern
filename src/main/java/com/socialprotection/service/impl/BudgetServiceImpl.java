package com.socialprotection.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialprotection.repository.BudgetRepository;
import com.socialprotection.repository.ExpenseRepository;
import com.socialprotection.repository.IncomeRepository;
import com.socialprotection.service.BudgetService;

@Service
public class BudgetServiceImpl implements BudgetService{
	
	@Autowired
	private BudgetRepository budgetRepository;
	
	@Autowired
	private IncomeRepository incomeRepository;
	
	@Autowired
	private ExpenseRepository expenseRepository;
}
