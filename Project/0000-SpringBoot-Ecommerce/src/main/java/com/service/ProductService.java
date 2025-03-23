package com.service;

import java.util.List;

import com.model.Category;
import com.model.Product;

public interface ProductService {

	public void addOrUpdateProduct(Product p);
	public List<Product> getAllProduct();
	public List<Category> getAllCategory();
	public Product getProductById(int id);
	public void deleteProduct(int id);
	public List<Product> getProductByCategory(Category c);
	
}
