package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Cart;
import com.model.User;
import com.repo.CartRepo;

@Service
public class CartServiceImp implements CartService {
	
	@Autowired
	CartRepo cartRepo;

	@Override
	public void addOrUpdateCart(Cart c) {
		// TODO Auto-generated method stub
		cartRepo.save(c);
	}

	@Override
	public List<Cart> getAllCart() {
		// TODO Auto-generated method stub
		return cartRepo.findAll();
	}

	@Override
	public void deleteCartById(int id) {
		// TODO Auto-generated method stub
		cartRepo.deleteById(id);
	}

	@Override
	public Cart getCartById(int id) {
		// TODO Auto-generated method stub
		return cartRepo.findById(id).orElseThrow();
	}

	@Override
	public List<Cart> cartFindByUser(User u) {
		// TODO Auto-generated method stub
		return cartRepo.findByUser(u);
	}
	
	@Transactional
	@Override
	public void deleteByUser(User u) {
		// TODO Auto-generated method stub
		cartRepo.deleteByUser(u);
	}

}
