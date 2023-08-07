package com.socialprotection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socialprotection.entity.Category;
import com.socialprotection.service.CategoryService;

@CrossOrigin
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		return ResponseEntity.ok(categoryService.saveCategory(category));
	} 
	
	@GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Category> getCategory(){
		return categoryService.getCategory();
	}
	
	@DeleteMapping(value = "/deleteCategory", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteCategory(@RequestParam Long categoryId) {
		categoryService.deleteCategory(categoryId);
	}

}
