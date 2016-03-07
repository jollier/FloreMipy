package com.floremipy.model.customer;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.floremipy.model.Adress;
import com.floremipy.model.Customer;
import com.floremipy.model.customer.dao.ModelCustomerDao;

public class FloreModelCustomerTest {
	
	private final static String PERSISTENCE_UNIT_NAME = "FloreMipyWeb";
	public static EntityManagerFactory emf;
	public static EntityManager em;
	public static EntityTransaction transaction;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em =  emf.createEntityManager();
		transaction =  em.getTransaction();
	}
	
	
	@Test
	public void testIdLastCustomer() {
		ModelCustomerDao modelCustomerDao = new ModelCustomerDao();
		int id;
		id = modelCustomerDao.FindIdLastCustomer();
		System.out.println("MaxId : " + id);
		assertEquals(id,8);
	}
	

	public void testCustomerDaoSave() {
		ModelCustomerDao modelCustomerDao = new ModelCustomerDao();
		Adress adress = new Adress ("rue du village","31000","Toulouse");
		Customer customer = new Customer ("Teste","Test","(555)555-5555","test.teste@mail.com",adress);
		modelCustomerDao.CustomerDaoSave(customer);
//		System.out.println("Customer : " +resultArticle.toString());
//		assertEquals(id,resultArticle.getId());
	}
	

}
