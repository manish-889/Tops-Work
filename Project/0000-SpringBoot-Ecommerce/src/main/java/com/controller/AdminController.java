package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.service.OrderService;
import com.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrderService orderService;

	@GetMapping("/adminDashboard")
	public String adminDashboard() {
		return "adminDashboard";
	}
	
	@GetMapping("/adminOrder")
	public String adminOrder(Model m) {
		m.addAttribute("orders", orderService.getAllOrders());
		return "adminOrder";
	}
	
	@GetMapping("/adminUserList")
	public String adminUserList(Model m) {
		m.addAttribute("userList", userService.getAllUser());
		return "adminUserList";
	}
	
}
