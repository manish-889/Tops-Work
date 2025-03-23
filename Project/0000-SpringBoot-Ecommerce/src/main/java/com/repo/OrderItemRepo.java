package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {

}
