package com.socialprotection.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.socialprotection.entity.Budget;

public interface BudgetService {
	
	public List<Budget> getList();
	
	public Budget getBudget(Long id);
	
	public void save(Budget budget);
	
	public void delete(Long id);
	
	public Page<Budget> getListPage(Pageable pageable);
	
	public List<Budget> searchBudget(String query);
}