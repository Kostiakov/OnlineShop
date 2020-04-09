package controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import entity.Food;
import entity.Products;
import service.ShopService;

public class TestController {
	
	@Mock
	ShopService service;
	
	@InjectMocks
	ShopController shopController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(shopController).build();
	}
	
	@Test
	public void showList() throws Exception {
		
		List<Products> products = new ArrayList<>();
		products.add(new Food());
		
		Mockito.when(service.getProducts()).thenReturn(products);
		
		mockMvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("productName"))
		.andExpect(model().attributeExists("addedProduct"));
	}

}
