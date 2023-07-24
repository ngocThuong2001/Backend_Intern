package com.socialprotection.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialprotection.entity.Budget;
import com.socialprotection.repository.BudgetRepository;

@Service
@Transactional
public class BudgetServiceImpl {
	
	@Autowired
	private BudgetRepository budgetrepository;

	public List<Budget> getList() {
		return budgetrepository.findAll();
	}
}
