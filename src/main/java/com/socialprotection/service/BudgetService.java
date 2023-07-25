package com.socialprotection.service;

import java.util.List;
import java.util.Optional;

import com.socialprotection.entity.Budget;

public interface BudgetService {
	
	public List<Budget> getList();
	
	public Optional<Budget> getBudget(Long id);
}