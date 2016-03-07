package com.floremipy.model.customer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.floremipy.model.Adress;
import com.floremipy.model.Customer;
import com.floremipy.model.customer.dao.ModelCustomerDao;

public class FloreModelCustomerTest {
	
	@Test
	public void testCustomerDaoSave() {
		Adress adress = new Adress ("rue du village","31000","Toulouse");
		Customer customer = new Customer ("Teste","Test","(555)555-5555","test.teste@mail.com",adress);
		ModelCustomerDao.CustomerDaoSave(customer);
//		System.out.println("Customer : " +resultArticle.toString());
//		assertEquals(id,resultArticle.getId());
	}
	

}
