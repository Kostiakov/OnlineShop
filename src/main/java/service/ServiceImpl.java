package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Dao;
import entity.Products;

@Service
public class ServiceImpl implements ShopService {
	
	@Autowired
	Dao dao;

	@Override
	public List<Products> getProducts() {
		return dao.getProducts();
	}

}
