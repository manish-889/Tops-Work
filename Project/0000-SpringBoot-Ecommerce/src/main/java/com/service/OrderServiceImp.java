package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Order;
import com.repo.OrderRepo;

@Service
public class OrderServiceImp implements OrderService {
	
	@Autowired
	OrderRepo orderRepo;

	@Override
	public Order addOrederDetails(Order order) {
		// TODO Auto-generated method stub
		return orderRepo.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}

}
