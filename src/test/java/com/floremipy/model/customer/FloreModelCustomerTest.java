package com.floremipy.model.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.floremipy.model.Adress;
import com.floremipy.model.Customer;
import com.floremipy.model.article.dao.ArticleDao;
import com.floremipy.model.article.dao.IArticleDao;
import com.floremipy.model.article.dto.ArticleDto;
import com.floremipy.model.article.dto.ArticleLightDto;
import com.floremipy.model.customer.dao.IModelCustomerDao;
import com.floremipy.model.customer.dao.ModelCustomerDao;
import com.floremipy.model.customer.dto.CustomerDto;
import com.floremipy.model.customer.dto.CustomerLightDto;
import com.floremipy.user.dto.UserDto;

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
	
	
//	@Test
//	public void testCustomerDaoSave() {
//		ModelCustomerDao modelCustomerDao = new ModelCustomerDao();
//		Adress adress = new Adress ("rue du village","31000","Toulouse");
//		Customer customer = new Customer ("test.teste@mail.com","Teste","Test","(555)555-5555",adress);
//		modelCustomerDao.CustomerDaoSave(customer);				
//	}
	
	
	@Test
	public void findAllCustomers(){
		IModelCustomerDao modelDao = new ModelCustomerDao();
		List<CustomerDto> result = modelDao.findAllCustomers();
		for(CustomerDto c : result){
			System.out.println("result test findAllCustomers "+ c);
		}
		assertTrue(result.size() > 0);	
	}
	
	@Test
	
	public void testFindArticleById() {
		int id = 1;
		IModelCustomerDao modelDao = new ModelCustomerDao();
		CustomerDto result = modelDao.findCustomerById(id);
		System.out.println("result test findCustomerById : " +result.toString());
		assertEquals(id,result.getId());
	
	}
	
	@Test
	public void testFindAllCustomersLight() {
		IModelCustomerDao modelDao = new ModelCustomerDao();
		List<CustomerLightDto> result = modelDao.findAllCustomersLight();
		for(CustomerLightDto a : result){
			System.out.println("result test FindAllArticlesLight : " +a);
		}	
		assertTrue(result.size() > 0);
	}
	
	@Test
	public void testFindCustomerLightById() {
		int id = 1;
		IModelCustomerDao modelDao = new ModelCustomerDao();
		CustomerLightDto result = modelDao.findCustomerLightById(id);
		System.out.println("result test FindCustomerLightById : " +result.toString());
		assertEquals(id,result.getId());
	}
	

}
