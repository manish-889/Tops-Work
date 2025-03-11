package com.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.model.Category;
import com.model.Product;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.UserService;

@Controller
public class AdminController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;

	@GetMapping("/adminDashboard")
	public String adminDashboard() {
		return "adminDashboard";
	}
	
	//********************* ALL Handler For Category ************************* //
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
	//********************* Ends Of Handler For Category *************************//
	
	//##################### All Handler For Product #########################//
	
	@GetMapping("/adminProduct")
	public String adminProduct(Model m) {
		m.addAttribute("product", new Product());
		m.addAttribute("products", productService.getAllProduct());
		m.addAttribute("categories",productService.getAllCategory());
		
		return "adminProduct";
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@ModelAttribute("product") Product p, @RequestParam("fileName") MultipartFile img,
			Model m) throws IOException  {
		
		String fileName = img.getOriginalFilename();
		String path = "C:\\Users\\ViP\\SpringBoot-Tops-Work\\0000-SpringBoot-Ecommerce\\src\\main\\webapp\\Img";
		
		BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream(path + "/" +fileName));
		
		byte b[] = img.getBytes(); 
		
		bf.write(b);
		bf.close();
		
		p.setImageName(fileName);
		productService.addOrUpdateProduct(p);
		
		return "redirect:/adminProduct";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("did") int id) {
		productService.deleteProduct(id);
		return "redirect:/adminProduct";
	}
	
	@GetMapping("/editProduct")
	public String editProduct(@RequestParam("uid") int id, Model m) {
		Product p =  productService.getProductById(id);
		m.addAttribute("product", p);
		m.addAttribute("products", productService.getAllProduct());
		m.addAttribute("categories", productService.getAllCategory());
		return "adminProduct";
	}
	
	//#################### Ends of Handler For Product ######################//

	
	@GetMapping("/adminOrder")
	public String adminOrder() {
		return "adminOrder";
	}
	
	@GetMapping("/adminUserList")
	public String adminUserList(Model m) {
		m.addAttribute("userList", userService.getAllUser());
		return "adminUserList";
	}
	
}
