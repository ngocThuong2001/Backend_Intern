package com.socialprotection.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialprotection.entity.Budget;
import com.socialprotection.service.BudgetService;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

	@Autowired
	private BudgetService budgetservice;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Budget>> listBudget() {
		List<Budget> listEmp = budgetservice.getList();
		return ResponseEntity.ok(listEmp);
	}
	
	@GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Budget>> getBudget(@PathVariable Long id) {
		Optional<Budget> budget = budgetservice.getBudget(id);
		return ResponseEntity.ok(budget);
	}
}
