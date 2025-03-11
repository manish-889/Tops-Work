package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.User;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	//************** All Handler For Register Of User ********************//
	
	@GetMapping("/registration")
	public String registration(Model m) {
		m.addAttribute("user", new User());
		return "registration";
	}
	
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute("user") User u) {
		service.addOrUpdateUser(u);
		return "redirect:/registration";
	}
	
	@GetMapping("/shop")
	public String shop(Model m)  {
		m.addAttribute("products", productService.getAllProduct());
		m.addAttribute("categories", categoryService.getAllCategory());
		return "shop";
	}
	
	@GetMapping("/productDetails")
	public String productDetails() {
		return "productDetails";
	}
	
	@GetMapping("/checkout")
	public String checkout() {
		return "checkout";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
}
