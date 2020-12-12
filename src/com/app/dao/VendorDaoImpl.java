package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.app.pojos.Vendor;

@Repository //spring bean 
public class VendorDaoImpl implements IVendorDao {
	// DAO : dependent obj , dependency : SessionFactory
	@Autowired // autowire=byType
	private SessionFactory factory;

	@Override
	public Vendor authenticateUser(String email, String password) {
		Vendor v = null;
		String jpql = "select v from Vendor v  where v.email=:em and v.password=:pass";

		v = factory.getCurrentSession().createQuery(jpql, Vendor.class).setParameter("em", email)
				.setParameter("pass", password).getSingleResult();

		return v;// dao layer is returning DETACHED vendor to JB
	}

}
