package com.floremipy.model.customer.dao;


import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.floremipy.model.Customer;

import com.floremipy.model.customer.dto.CustomerDto;

import com.floremipy.model.article.dto.ArticleDto;


public class ModelCustomerDao {

	
	private final static String PERSISTENCE_UNIT_NAME = "floremipi";
	private static EntityManagerFactory emf;	
	private static EntityManager em;	
	
	public ModelCustomerDao() {
		//		super();
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
	}
	
	public int FindIdLastCustomer() {
		int id = 0;
		
		String requete = 
				"SELECT NEW com.floremipy.model.dto.ArticleDto(" + 
						"a.id, a.category, a.description, a.imgsrc, a.name, a.quantityInStock) " +
						"FROM Article a order by a.name" ;
		Query query = null;
		query = em.createQuery(requete, ArticleDto.class);
//		return (List<ArticleDto>)query.getResultList();
		
		return id;
	}
	
	public static void CustomerDaoSave (Customer customer) {
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
	}
	
	public List<CustomerDto> findAllCustomers(){
		String requete = 
				"SELECT NEW com.floremipy.model.dto.CustomerDto(" + 
		"a.id , a.name, a.firstname, a.phone, a.email, a.adress)" +
						"From Customer ORDER BY name";
		Query query = null;
		query=em.createQuery(requete, CustomerDto.class);		
		return (List<CustomerDto>)query.getResultList();		
	}
	
	public CustomerDto findCustomerById(int id){
		String requete = "SELECT New com.floremipy.dto.CustomerDto(" +
				"a.id , a.name, a.firstname, a.phone, a.email, a.adress)" +
				"From Customer WHERE a.id = id";
		
		return null;		
	}
	
	

}
