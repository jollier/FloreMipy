package com.floremipy.model.customer.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.floremipy.model.Customer;
import com.floremipy.model.customer.dto.CustomerDto;
import com.floremipy.model.customer.dto.CustomerLightDto;
import com.floremipy.user.dto.UserDto;



@Component
public class ModelCustomerDao implements IModelCustomerDao {

	
	private final static String PERSISTENCE_UNIT_NAME = "FloreMipyWeb";
	private static EntityManagerFactory emf;	
	private static EntityManager em;	
	
	public ModelCustomerDao() {
		//		super();
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
	}
	
	public String FindNameLastCustomer() {
		String requete = 
				"SELECT NEW com.floremipy.model.customer.dto.CustomerDto(" + 
						"c.id,c.name, c.firstName, c.phone, c.email, c.adress) " +
						"FROM Customer c ORDER BY c.id DESC" ;

		Query query = null;
		query = em.createQuery(requete, CustomerDto.class);
		List<CustomerDto> lst=((List<CustomerDto>)query.getResultList());
		CustomerDto res = lst.get(0);
		
		return res.getName();
	}
	
	public CustomerDto CustomerDaoSave (CustomerDto customerDto) {
		Customer customer = new Customer();
		
		customer.setName(customerDto.getName());
		customer.setFirstName(customerDto.getFirstname());
		customer.setEmail(customerDto.getEmail());
		customer.setPhone(customerDto.getPhone());
		customer.setAdress(customerDto.getAdress());
		
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
		
		return (CustomerDto)findCustomerByEmail(customerDto.getEmail());
		
	}
	
	public void CustomerDaoRemove (Customer customer) {
		em.getTransaction().begin();
		em.remove(customer);
		em.getTransaction().commit();
	}
	
	public List<CustomerDto> findAllCustomers(){
		String requete = 
				"SELECT NEW com.floremipy.model.customer.dto.CustomerDto(" + 
		"a.id , a.name, a.firstName, a.phone, a.email, a.adress)" +
						"FROM Customer a ORDER BY a.name";
		Query query = null;
		query=em.createQuery(requete, CustomerDto.class);		
		return (List<CustomerDto>)query.getResultList();		
	}
	
	public CustomerDto findCustomerById(int id){
		String requete = "SELECT New com.floremipy.model.customer.dto.CustomerDto(" +
				"a.id , a.name, a.firstName, a.phone, a.email, a.adress)" +
				"From Customer a  WHERE a.id = :id";
		Query query = null;
		query=em.createQuery(requete, CustomerDto.class);
		query.setParameter("id", id);
		return (CustomerDto)query.getSingleResult();
				
	}
	
	public List<CustomerLightDto> findAllCustomersLight(){
		String requete = 
				"SELECT NEW com.floremipy.model.customer.dto.CustomerLightDto(" + 
		"a.id , a.name, a.firstName)" +
						"From Customer a ORDER BY a.name";
		Query query = null;
		query=em.createQuery(requete, CustomerDto.class);		
		return (List<CustomerLightDto>)query.getResultList();		
	}
	
	public CustomerLightDto findCustomerLightById(int id){
		String requete = "SELECT New com.floremipy.model.customer.dto.CustomerLightDto(" +
				"a.id , a.name, a.firstName)" +
				"From Customer a WHERE a.id = :id";
		Query query = null;
		query=em.createQuery(requete, CustomerDto.class);
		query.setParameter("id", id);
		return (CustomerLightDto)query.getSingleResult();		
	}

	public CustomerDto findCustomerByEmail(String email){
		String requete = "SELECT New com.floremipy.model.customer.dto.CustomerDto(" +
				"a.id , a.name, a.firstName, a.phone, a.email, a.adress)" +
				"From Customer a  WHERE a.email = :email";
		Query query = null;
		query=em.createQuery(requete, CustomerDto.class);
		query.setParameter("email", email);
		
		CustomerDto result = null;
		try {
			 result = (CustomerDto)query.getSingleResult();
		} catch (Exception e) {
			result = null;
		}
		return result;
			
	}

}
