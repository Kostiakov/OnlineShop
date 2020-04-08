package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import entity.Food;
import entity.Products;
import service.ShopService;

@Controller
public class ShopController {
	
	public ShopController() {
		
	}
	
	@Autowired
	ShopService service;
	
	@GetMapping("/")
	public String showHome(Model model, HttpSession session) {
		if(session.getAttribute("cart") == null) {
			List<Products> cart = new ArrayList<>();
			session.setAttribute("cart", cart);
			System.out.println("Cart created");
		}
		List<Products> cartModel = (List<Products>) session.getAttribute("cart");
		System.out.println(cartModel);
		model.addAttribute("cartModel", cartModel);
		model.addAttribute("productName", new Food());
		model.addAttribute("addedProduct", new Food());
		return "home";
	}
	
	@GetMapping("/productList")
	public String showProducts(Model model) {
		List<Products> list = service.getProducts();
		model.addAttribute("products", list);
		return "productList";
	}
	
	@PostMapping("/searchProduct")
	public String searchProducts(@ModelAttribute("productName") Food productName, Model model) {
		List<Products> list = service.getProducts();
		list = list.stream().filter(a->a.getName().equals(productName.getName())).collect(Collectors.toList());
		model.addAttribute("foundProducts", list);
		return "productSearch";
	}
	
	@PostMapping("/addProductToCart")
	public String addProductToCart(@ModelAttribute("addedProduct") Food productName, Model model, HttpSession session) {
		List<Products> cart = (List<Products>) session.getAttribute("cart");
		cart.add(productName);
		session.setAttribute("cart", cart);
		return "addedProduct";
	}

}