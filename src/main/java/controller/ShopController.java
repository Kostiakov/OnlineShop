package controller;

import java.util.List;
import java.util.stream.Collectors;

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
	
	@Autowired
	ShopService service;
	
	@GetMapping("/")
	public String showHome(Model model) {
		model.addAttribute("productName", new Food());
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

}
