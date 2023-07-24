package com.socialprotection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.socialprotection.entity.Budget;
import com.socialprotection.service.BudgetService;

@RestController
@RequestMapping("/api/budget")
public class BudgetController {

	@Autowired
	private BudgetService budgetservice;

	@RequestMapping(value = "/fetch")
	public ModelAndView listEmployee(ModelAndView model) {
		List<Budget> listEmp = budgetservice.getList();
		model.addObject("listEmp", listEmp);
		model.setViewName("index");
		return model;
	}
}
