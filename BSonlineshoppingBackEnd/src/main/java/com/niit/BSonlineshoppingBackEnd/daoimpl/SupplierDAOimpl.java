package com.niit.BSonlineshoppingBackEnd.daoimpl;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BSonlineshoppingBackEnd.dao.SupplierDAO;

import com.niit.BSonlineshoppingBackEnd.dto.Supplier;


@Repository("supplierDAO")
@Transactional
public class SupplierDAOimpl implements SupplierDAO {
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<Supplier> list() {
		String selectActiveSupplier = "FROM Supplier WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveSupplier);
		query.setParameter("active",true);
		return query.getResultList();
	}

	/*
	 * Getting a single Supplier based on id
	 */
	@Override
	public Supplier get(int id) {

		return sessionFactory.getCurrentSession().get(Supplier.class,Integer.valueOf(id));

	}

	@Override
	
	public boolean add(Supplier supplier) {
	try {
		//add the Supplier to the database table
		sessionFactory.getCurrentSession().persist(supplier);
		return true;
	}
	catch(Exception ex) {
		ex.printStackTrace();
		return false;
	}
		
	}

	/*
	 * Updating a single Supplier
	 */
	@Override
	public boolean update(Supplier supplier) {
		try {
			//add the Supplier to the database table
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}	
	
	}

	@Override
	public boolean delete(Supplier supplier) {
		supplier.setActive(false);
		try {
			//add the Supplier to the database table
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}	
	}

}
