package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Category;
import com.model.Product;
import com.repo.CategoryRepo;
import com.repo.ProductRepo;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Override
	public void addOrUpdateProduct(Product p) {
		// TODO Auto-generated method stub
		if (productRepo.existsById(p.getProductId())) {  
	        Product existingProduct = productRepo.findById(p.getProductId()).orElseThrow();
	        existingProduct.setProductName(p.getProductName());
	        existingProduct.setPrice(p.getPrice());
	        existingProduct.setImageName(p.getImageName());
	        existingProduct.setQuantity(p.getQuantity());
	        existingProduct.setCategory(p.getCategory());
	        productRepo.save(existingProduct); 
	    } else {
	    	productRepo.save(p);
	    }
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).orElseThrow();
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		productRepo.deleteById(id);
	}

}
