package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.OrderItem;
import com.repo.OrderItemRepo;

@Service
public class OrderItemServiceImp implements OrderItemService{

	@Autowired
	OrderItemRepo itemRepo;
	
	@Override
	public OrderItem addOrderItem(OrderItem item) {
		// TODO Auto-generated method stub
		return itemRepo.save(item);
	}

}
