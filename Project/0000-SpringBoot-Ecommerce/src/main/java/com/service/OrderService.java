package com.service;

import java.util.List;

import com.model.Order;

public interface OrderService  {

	public Order addOrederDetails(Order order);
	public List<Order> getAllOrders();
	
}
