package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Helper.EmailSender;
import com.model.Cart;
import com.model.Category;
import com.model.OrderItem;
import com.model.Product;
import com.model.User;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.service.CartService;
import com.service.CategoryService;
import com.service.OrderItemService;
import com.service.OrderService;
import com.service.ProductService;
import com.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService service;

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;

	@Autowired
	CartService cartService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderItemService itemService;

	@GetMapping("/")
	public String index(Model m) {

		m.addAttribute("productList", productService.getAllProduct());
		return "home";
	}

	// Handler for user registration
	@GetMapping("/registration")
	public String registration(Model m) {
		m.addAttribute("user", new User());
		return "registration";
	}

	// Handler for add User
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute("user") User u) {
		service.addOrUpdateUser(u);
		return "redirect:/registration";
	}

	@GetMapping("/shop")
	public String shop(Model m) {

		m.addAttribute("products", productService.getAllProduct());
		m.addAttribute("categories", categoryService.getAllCategory());
		return "shop";
	}
	
	@GetMapping("/getProduct")
	public String getProduct(@RequestParam("id")int cid,Model m) {
		
		Category cId = categoryService.getCategoryById(cid);
		
		m.addAttribute("products", productService.getProductByCategory(cId));
		m.addAttribute("categories", categoryService.getAllCategory());
		
		return "shop";
	}
	

	@GetMapping("/productDetails")
	public String productDetails(@RequestParam("pid") int id, Model m) {

		Product product = productService.getProductById(id);
		m.addAttribute("productDetails", product);
		return "productDetails";
	}

	// ************************ All Handler for Cart ************************//

	@GetMapping("/cart")
	public String cart(Model m, HttpSession session) {
		User u = (User) session.getAttribute("userData");
		if (u == null) {
			return "redirect:/login";
		}
		m.addAttribute("cart", cartService.cartFindByUser(u));
		return "cart";
	}

	@GetMapping("/addCart")
	public String cart(@RequestParam("productId") int id, @RequestParam("quantity") int qty, Model m,
			HttpSession session, @ModelAttribute("cart") Cart c) {
		User u = (User) session.getAttribute("userData");
		Product product = productService.getProductById(id);

		if (u == null) {
			return "redirect:/login";
		}

		c.setProduct(product);
		c.setUser(service.getUserById(u.getUserId()));
		c.setProductQuantity(qty);

		cartService.addOrUpdateCart(c);

		return "redirect:/cart";
	}

	@GetMapping("/remove")
	public String removeCart(@RequestParam("cid") int id) {
		cartService.deleteCartById(id);
		return "redirect:/cart";
	}

	// *********************** Ends of Handler for Cart ************************//

	@PostMapping("/loginAction")
	public String loginAction(@RequestParam("email") String email, @RequestParam("pass") String password,
			HttpSession session) {

		User user = service.getUserByEmailAndPass(email, password);
		if (user == null) {
			return "redirect:/login";
		}

		session.setAttribute("userData", user);
		session.setAttribute("userEmail", email);
		return "redirect:/";
	}

	@GetMapping("/checkout")
	public String checkout(HttpSession session, Model m) {
		
		User u = (User) session.getAttribute("userData");
		if (u == null) {
			return "redirect:/login";
		}
		
		m.addAttribute("userData", u);
		m.addAttribute("cart", cartService.cartFindByUser(u));
		return "checkout";
	}

	@GetMapping("/payment")
	public void Payment(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PrintWriter pw = resp.getWriter();
		double amt = Double.parseDouble(req.getParameter("amt"));
		
		JSONObject orderRequest = new JSONObject();
		orderRequest.put("amount", amt * 100); // Amount is in currency subunits. Default currency is INR. Hence, 50000
												// refers to 50000 paise
		orderRequest.put("currency", "INR");
		orderRequest.put("receipt", "receipt#1");
		JSONObject notes = new JSONObject();
		notes.put("notes_key_1", "Tea, Earl Grey, Hot");
		orderRequest.put("notes", notes);

		try {
			RazorpayClient razorpay = new RazorpayClient("rzp_test_OHjwiuWFUgliRX", "MgSQP5FuKStGTP3NsKnKDpiP");
			Order order = razorpay.orders.create(orderRequest);
			pw.append(order.toString());

		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@GetMapping("/addOrder")
	public String addOrder(@RequestParam("oId")String id, HttpServletRequest req,HttpServletResponse resp,HttpSession session) {
		
		User u = (User) session.getAttribute("userData");
		com.model.Order order = new com.model.Order();
		order.setPaymentType(id);
		order.setOrderDate(new Date().toString());
		order.setUser(service.getUserById(u.getUserId()));
		com.model.Order orederDetails = orderService.addOrederDetails(order);
	
		List<Cart> carts = cartService.cartFindByUser(u);
	
		
		
		for (Cart cart : carts) {
			OrderItem item = new OrderItem();
			item.setOrder(orederDetails);
			item.setPrice(cart.getProduct().getPrice());
			item.setProduct(cart.getProduct());
			item.setProductQuantity(cart.getProductQuantity());
			
			itemService.addOrderItem(item);
		}
 		
		EmailSender.send(u.getEmail(), "Order Confirmation", "Your Order is confrim. Thank for choosing us.");
		
		cartService.deleteByUser(u);
		
		return "Done";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
