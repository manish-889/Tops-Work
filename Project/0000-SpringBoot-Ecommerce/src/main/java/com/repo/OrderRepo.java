package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

}
