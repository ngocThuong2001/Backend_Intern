package com.socialprotection.service;

import java.util.List;

import com.socialprotection.entity.Expense;

public interface ExpenseService {

	public List<Expense> getList();

	public Expense getExpense(Long id);

	public void save(Expense expense);

	public void delete(Long id);
}
