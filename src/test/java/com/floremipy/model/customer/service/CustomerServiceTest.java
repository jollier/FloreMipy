package com.floremipy.model.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.floremipy.model.customer.dao.IModelCustomerDao;
import com.floremipy.model.customer.dto.CustomerDto;
import com.floremipy.user.dao.UserDao;
import com.floremipy.user.dto.UserDto;

public class CustomerServiceTest {

	@Test
	public void testGetCustomerByLoginAndPassword(){
		// *******************************************
		// ****               Arrange             ****
		// *******************************************
		// *** Pour la mise en place du test      ****
		// *******************************************
		IModelCustomerDao customerDao = Mockito.mock(IModelCustomerDao.class);
		UserDao userDao = Mockito.mock(UserDao.class);
		
		CustomerDto customerDto = new CustomerDto();
		customerDto.setName("DURAND");
		
		UserDto userDto = new UserDto();
		userDto.setUsername("TEST");
		userDto.setIdcustomer(1);
		
		Mockito.when(customerDao.findCustomerById(1)).thenReturn(customerDto);
		Mockito.when(userDao.findUserByUserNameAndPassword("TEST","PASSWORD")).thenReturn(userDto);
		
		CustomerService customerService = new CustomerService();
		customerService.setCustomerDao(customerDao);
		customerService.setUserDao(userDao);

		// *****************************************************
		// ****                     Act                     ****
		// *****************************************************
		// *** Pour l'execution de la méthode à tester      ****
		// *****************************************************
		CustomerDto customerDto1 = customerService.getCustomerByLoginAndPassword("TEST", "PASSWORD");
		
		// *****************************************************
		// ****                  Assert                     ****
		// *****************************************************
		// *** Pour vérifier le résultat du test            ****
		// *****************************************************		
		Assert.assertNull(customerDto1);
		//Assert.assertEquals("DURAND", customerDto1.getName());
		
	}
	
	@Test
	public void testfindAllCustomersDTO(){
		// *******************************************
		// ****               Arrange             ****
		// *******************************************
		IModelCustomerDao customerDao = Mockito.mock(IModelCustomerDao.class);
		
		CustomerDto customer1 = new CustomerDto();
		CustomerDto customer2 = new CustomerDto();
		List<CustomerDto> liste = new ArrayList<CustomerDto>();
		liste.add(customer1);
		liste.add(customer2);
		
		Mockito.when(customerDao.findAllCustomers()).thenReturn(liste);
		
		CustomerService customerService = new CustomerService();
		customerService.setCustomerDao(customerDao);
		// *****************************************************
		// ****                     Act                     ****
		// *****************************************************
		List<CustomerDto> list = customerService.findAllCustomers();
		
		// *****************************************************
		// ****                  Assert                     ****
		// *****************************************************		
		Assert.assertEquals(2, list.size());		
	}
}
