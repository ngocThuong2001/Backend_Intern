package com.socialprotection.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.socialprotection.entity.Budget;
import com.socialprotection.repository.BudgetRepository;
import com.socialprotection.service.BudgetService;

@Service
public class BudgetServiceImpl implements BudgetService{
	
	@Autowired
	private BudgetRepository budgetRepository;
	
	public List<Budget> getList() {
		return budgetRepository.findAll();
	}
	
	public Budget getBudget(Long id) {
		return budgetRepository.findOne(id);
	}
	
	public void save(Budget budget) {
		budgetRepository.save(budget);
    }
	
	public void delete(Long id) {
		budgetRepository.delete(id);
    }
	
	public Page<Budget> getListPage(Pageable pageable) {
		return budgetRepository.findAll(pageable);
	}
	
	@Override
	public List<Budget> searchBudget(String query) {
//		List<Budget> budget = budgetRepository.searchBudget(query);
		List<Budget> budget = budgetRepository.findByBudgetNameLike(query);
		return budget;
	}
	
}
