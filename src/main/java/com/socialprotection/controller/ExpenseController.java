package com.socialprotection.controller;

import java.util.List;

import org.eclipse.jetty.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialprotection.entity.Expense;
import com.socialprotection.service.ExpenseService;

@CrossOrigin
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseservice;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Expense>> listExpense() {
		List<Expense> listExpense = expenseservice.getList();
		return ResponseEntity.ok(listExpense);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Expense> getExpense(@PathVariable("id") Long id) {
		Expense itemEx = expenseservice.getExpense(id);
		return ResponseEntity.ok(itemEx);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Expense> addBudget(@RequestBody Expense expense) {
		try {
			Expense _expense = new Expense(expense.getBudget(), expense.getBankAccount(), expense.getExpenseName(), expense.getExpenseDescription(), expense.getAmount(),
					expense.getDateTime());
			expenseservice.save(_expense);
			return ResponseEntity.ok(_expense);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR_500).body(null);
		}
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Expense> updateTutorial(@PathVariable("id") long id, @RequestBody Expense expense) {
		Expense itemEx = expenseservice.getExpense(id);
		itemEx.setBudget(expense.getBudget());
		itemEx.setBankAccount(expense.getBankAccount());
		itemEx.setExpenseName(expense.getExpenseName());
		itemEx.setExpenseDescription(expense.getExpenseDescription());
		itemEx.setAmount(expense.getAmount());
		itemEx.setDateTime(expense.getDateTime());
		return ResponseEntity.ok(itemEx);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTutorial(@PathVariable("id") Long id) {
		try {
			expenseservice.delete(id);
			return ResponseEntity.ok("Delete Success!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR_500).body(null);
		}
	}
}
