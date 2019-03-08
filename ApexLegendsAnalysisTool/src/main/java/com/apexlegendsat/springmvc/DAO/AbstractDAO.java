package com.apexlegendsat.springmvc.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void delete(Object entity) {
		getSession().delete(entity);
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void persist(Object entity) {
		getSession().persist(entity);
	}
	
}
