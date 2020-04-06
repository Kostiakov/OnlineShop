package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Products;
import service.ShopService;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	ShopService service;
	
	@GetMapping("/home")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/productList")
	public String showProducts(Model model) {
		List<Products> list = service.getProducts();
		model.addAttribute("products", list);
		return "productList";
	}

}
