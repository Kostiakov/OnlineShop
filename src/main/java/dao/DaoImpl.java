package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import entity.Products;

@Repository
public class DaoImpl implements Dao {

	@Autowired
	private SessionFactory factory;
	
	
	@Override
	public List<Products> getProducts() {
		Session session = factory.getCurrentSession();
		List<Products> listNew = session.createQuery("from Products").list();
		return listNew;
	}

	@Override
	public List<Products> getProduct(String theName) {
		Session session = factory.getCurrentSession();
		Query theQuery = session.createQuery("from Products where name=:theName");
		theQuery.setParameter("theName", theName);
		List<Products> theProducts = theQuery.getResultList();
		return theProducts;
	}

	@Override
	public void deleteProduct(int theId) {
		Session session = factory.getCurrentSession();
		Products theProduct = session.get(Products.class, theId);
		session.delete(theProduct);
	}

	@Override
	public void addProduct(Products theProduct) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(theProduct);
	}

}
