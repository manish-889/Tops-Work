package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Category;
import com.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/adminCategory")
	public String adminCategory(Model m) {
		m.addAttribute("category", new Category());
		m.addAttribute("categories", categoryService.getAllCategory());
		return "adminCategory";
	}
	
	@PostMapping("/addCategory")
	public String addCategory(@ModelAttribute("category") Category cat) {
		categoryService.addOrUpdateCategory(cat);
		return "redirect:/adminCategory";
	}
	
	@GetMapping("/delete")
	public String deleteCategory(@RequestParam("cid") int id) {
		categoryService.deleteCategory(id);
		return "redirect:/adminCategory";
	}
	
	@GetMapping("/edit")
	public String editCategory(@RequestParam("cid") int id, Model m) {
		m.addAttribute("category", categoryService.getCategoryById(id));
		m.addAttribute("categories", categoryService.getAllCategory());
		return "adminCategory";
	}

}
