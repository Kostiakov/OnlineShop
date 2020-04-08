package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		List<Products> list = service.getProduct(productName.getName());
		//list = list.stream().filter(a->a.getName().equals(productName.getName())).collect(Collectors.toList());
		model.addAttribute("foundProducts", list);
		return "productSearch";
	}
	
	@PostMapping("/addProductToCart")
	public String addProductToCart(@ModelAttribute("addedProduct") Food productName, Model model, HttpSession session) {
		List<Products> cart = (List<Products>) session.getAttribute("cart");
		List<Products> list = service.getProducts();
		Optional <Products> theProduct = list.stream().filter(a->a.getName().equals(productName.getName())).findAny();
		if(theProduct.isEmpty()) {
			return "errorProductName";
		}
		Products pr = theProduct.get();
		if(pr.getAmount()<productName.getAmount()) {
			return "errorProductAmount";
		}
		cart.add(productName);
		session.setAttribute("cart", cart);
		return "addedProduct";
	}
	
	@GetMapping("/cartList")
	public String showProductsInCart(Model model, HttpSession session) {
		List<Products> cartModel = (List<Products>) session.getAttribute("cart");
		model.addAttribute("cartProducts", cartModel);
		return "cartList";
	}
	
	@RequestMapping("/deleteProduct")
	public String deleteProductFromCart(@RequestParam("productName") String name, Model model, HttpSession session) {
		List<Products> cart = (List<Products>) session.getAttribute("cart");
		cart.removeIf(a->a.getName().equals(name));
		session.setAttribute("cart", cart);
		return "redirect:/cartList";
	}

}
