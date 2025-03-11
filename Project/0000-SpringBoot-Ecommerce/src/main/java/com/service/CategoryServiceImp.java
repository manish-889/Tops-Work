package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Category;
import com.repo.CategoryRepo;

@Service
public class CategoryServiceImp implements CategoryService {
	
	@Autowired
	CategoryRepo repo;

	@Override
	public void addOrUpdateCategory(Category category) {
		// TODO Auto-generated method stub
		repo.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow();
	}

}
