package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.Dao;
import entity.Products;

@Service
public class ServiceImpl implements ShopService {
	
	@Autowired
	Dao dao;

	@Transactional
	@Override
	public List<Products> getProducts() {
		return dao.getProducts();
	}

	@Transactional
	@Override
	public List<Products> getProduct(String name) {
		return dao.getProduct(name);
	}

}
