package com.service;

import java.util.List;

import com.model.Cart;
import com.model.User;

public interface CartService {

	public void addOrUpdateCart(Cart c);
	public List<Cart> getAllCart();
	public void deleteCartById(int id);
	public Cart getCartById(int id);
	public List<Cart> cartFindByUser(User u);
	public void deleteByUser(User u);
	
}
