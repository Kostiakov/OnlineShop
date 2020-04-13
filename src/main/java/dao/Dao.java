package dao;

import java.util.List;

import entity.Products;

public interface Dao {
	
	public List<Products> getProducts();
	public List<Products> getProduct(String name);
	public void deleteProduct(int theId);
	public void addProduct(Products theProduct);
	public Products getProductForOrder(String name);

}
