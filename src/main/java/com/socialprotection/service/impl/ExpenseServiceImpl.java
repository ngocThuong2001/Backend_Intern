package com.socialprotection.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialprotection.entity.Expense;
import com.socialprotection.repository.ExpenseRepository;
import com.socialprotection.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public List<Expense> getList() {
		return expenseRepository.findAll();
	}

	@Override
	public Expense getExpense(Long id) {
		return expenseRepository.findOne(id);
	}

	@Override
	public void save(Expense expense) {
		expenseRepository.save(expense);
	}

	@Override
	public void delete(Long id) {
		expenseRepository.delete(id);
	}
}
