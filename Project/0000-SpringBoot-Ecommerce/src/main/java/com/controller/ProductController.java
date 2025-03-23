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

import com.model.Product;
import com.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;

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
	
	
}
