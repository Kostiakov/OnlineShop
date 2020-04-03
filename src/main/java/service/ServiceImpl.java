package service;

import java.util.List;

import dao.DaoImpl;
import entity.Products;

public class ServiceImpl implements Service {

	@Override
	public List<Products> getProducts() {
		DaoImpl dao = new DaoImpl();
		return dao.getProducts();
	}

}
