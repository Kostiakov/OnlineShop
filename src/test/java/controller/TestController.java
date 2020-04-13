package controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import entity.Food;
import entity.Products;
import service.ShopService;

public class TestController {
	
	@Mock
	ShopService service;
	
	@InjectMocks
	ShopController shopController;
	
	private MockMvc mockMvc;
	private List<Products> theProducts;
	
	@Before
	public void setup() {
		
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(shopController).build();
		
		theProducts = new ArrayList<>();
		Food food = new Food();
		food.setName("Apple");
		food.setAmount(20);
		theProducts.add(food);
	}
	
	@Test
	public void showList() throws Exception {
		
		Mockito.when(service.getProducts()).thenReturn(theProducts);
		
		mockMvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("productName"))
		.andExpect(model().attributeExists("addedProduct"));
	}
	
	@Test
	public void addProduct() throws Exception {
		
		Food theFood = new Food();
		theFood.setName("Apple");
		theFood.setAmount(10);
		
		Mockito.when(service.getProducts()).thenReturn(theProducts);
		
		mockMvc.perform(post("/addProductToCart")
				.flashAttr("addedProduct", theFood)
				.sessionAttr("cart", theProducts))
		.andExpect(status().isOk())
		.andExpect(view().name("addedProduct"));
		
		MatcherAssert.assertThat(theProducts, hasSize(2));
	}
	
	@Test
	public void deleteProduct() throws Exception {
		
		String name = "Apple";
		
		mockMvc.perform(post("/deleteProduct")
				.param("productName", name)
				.sessionAttr("cart", theProducts))
		.andExpect(status().is3xxRedirection());
		
		MatcherAssert.assertThat(theProducts, hasSize(0));
	}
	
	@Test
	public void order() throws Exception {
		
		Food theFood = new Food();
		theFood.setName("Apple");
		theFood.setAmount(5);
		
		Mockito.when(service.getProductForOrder(theFood.getName())).thenReturn(theFood);
		
		mockMvc.perform(post("/order")
				.sessionAttr("cart", theProducts))
		.andExpect(status().is3xxRedirection());
		
		MatcherAssert.assertThat(theProducts, hasSize(0));
		
	}

}
