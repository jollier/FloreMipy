package com.floremipy.model.customer.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.floremipy.model.Customer;
import com.floremipy.model.customer.dto.CustomerDto;

public class ModelCustomerDao {

	
	private final static String PERSISTENCE_UNIT_NAME = "FloreMipyWeb";
	private static EntityManagerFactory emf;	
	private static EntityManager em;	
	
	public ModelCustomerDao() {
		//		super();
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
	}
	
	public int FindIdLastCustomer() {
		String requete = 
				"SELECT NEW com.floremipy.model.customer.dto.CustomerDto(" + 
						"MAX(c.id),c.name, c.firstName, c.phone, c.email, c.adress) " +
						"FROM Customer c" ;
		Query query = null;
		query = em.createQuery(requete, CustomerDto.class);
		CustomerDto res= ((CustomerDto)query.getSingleResult());
		
		return res.getId();
	}
	
	public void CustomerDaoSave (Customer customer) {
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
	}

}
