package dao;

import java.util.ArrayList;
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
		List<Products> listNew = new ArrayList<>();;
		/*List<Products> listNew;
		try (SessionFactory factory = new Configuration().configure("hibernateProducts.cfg.xml")
				.addAnnotatedClass(Products.class)
				.addAnnotatedClass(Food.class)
				.addAnnotatedClass(Nonfood.class)
				.buildSessionFactory()) {

			Session session = factory.getCurrentSession();
			session.beginTransaction();

			listNew = session.createQuery("from Products").list();

			session.getTransaction().commit();
		}*/
		Food food1 = new Food();
		food1.setName("Apple");
		food1.setAmount(20);
		food1.setPrice(60);
		food1.setCalories(50);
		Food food2 = new Food();
		food2.setName("Tomato");
		food2.setAmount(30);
		food2.setPrice(80);
		food2.setCalories(20);
		Nonfood nonfood1 = new Nonfood();
		nonfood1.setName("Pen");
		nonfood1.setAmount(100);
		nonfood1.setPrice(100);
		nonfood1.setLifeTime(3);
		Nonfood nonfood2 = new Nonfood();
		nonfood2.setName("Pencil");
		nonfood2.setAmount(200);
		nonfood2.setPrice(50);
		nonfood2.setLifeTime(10);
		listNew.add(food1);
		listNew.add(food2);
		listNew.add(nonfood1);
		listNew.add(nonfood2);
		return listNew;
	}

}
