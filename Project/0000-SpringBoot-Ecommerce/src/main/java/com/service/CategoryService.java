package com.service;

import java.util.List;

import com.model.Category;

public interface CategoryService {

	public void addOrUpdateCategory(Category category);
	public List<Category> getAllCategory();
	public void deleteCategory(int id);
	public Category getCategoryById(int id);
	
}
