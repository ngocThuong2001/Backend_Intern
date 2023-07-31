package com.socialprotection.controller;

import java.util.List;
import java.util.Optional;

import org.eclipse.jetty.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socialprotection.entity.Budget;
import com.socialprotection.service.BudgetService;

@CrossOrigin
@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

	@Autowired
	private BudgetService budgetservice;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Budget>> listBudget() {
		List<Budget> listBud = budgetservice.getList();
		return ResponseEntity.ok(listBud);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Budget> getBudget(@PathVariable("id") Long id) {
		Budget itemBud = budgetservice.getBudget(id);
		return ResponseEntity.ok(itemBud);
	}
	
	@GetMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Budget>> pageBudget(Budget budget, @RequestParam("p") Optional<Integer> p) {
		Pageable paging = new PageRequest(p.orElse(0), 5);
		Page<Budget> list = budgetservice.getListPage(paging);
		return ResponseEntity.ok(list.getContent());
	}

	@GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Budget>> resultBudget(@RequestParam("query") String query) {
		List<Budget> result = budgetservice.searchBudget(query);
		return ResponseEntity.ok(result);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Budget> addBudget(@RequestBody Budget budget) {
		try {
			Budget _budget = new Budget(budget.getBudgetName(), budget.getBudgetDescription(), budget.getAmout(),
					budget.getStartDate(), budget.getEndDate());
			budgetservice.save(_budget);
			return ResponseEntity.ok(_budget);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR_500).body(null);
		}
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Budget> updateTutorial(@PathVariable("id") long id, @RequestBody Budget budget) {
		Budget itemBud = budgetservice.getBudget(id);
		itemBud.setBudgetName(budget.getBudgetName());
		itemBud.setBudgetDescription(budget.getBudgetDescription());
		itemBud.setAmout(budget.getAmout());
		itemBud.setStartDate(budget.getStartDate());
		itemBud.setEndDate(budget.getEndDate());
		budgetservice.save(itemBud);
		return ResponseEntity.ok(itemBud);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTutorial(@PathVariable("id") Long id) {
		try {
			budgetservice.delete(id);
			return ResponseEntity.ok("Delete Success!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR_500).body(null);
		}
	}

}
