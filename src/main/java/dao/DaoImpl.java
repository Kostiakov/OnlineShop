package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Food;
import entity.Nonfood;
import entity.Products;

public class DaoImpl implements Dao {

	@Override
	public List<Products> getProducts() {
		List<Products> listNew;
		try (SessionFactory factory = new Configuration().configure("hibernateProducts.cfg.xml")
				.addAnnotatedClass(Products.class)
				.addAnnotatedClass(Food.class)
				.addAnnotatedClass(Nonfood.class)
				.buildSessionFactory()) {

			Session session = factory.getCurrentSession();
			session.beginTransaction();

			listNew = session.createQuery("from Products").list();

			session.getTransaction().commit();
		}
		return listNew;
	}

}
