package com.socialprotection.service;

import java.util.List;

import com.socialprotection.entity.Category;

public interface CategoryService {
	
	public Category saveCategory(Category category);
	
	public List<Category> getCategory();
	
	Category findById(long id);
	
	public void deleteCategory(Long categoryId);

}
