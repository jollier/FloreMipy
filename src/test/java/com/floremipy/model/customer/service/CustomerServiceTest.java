package com.floremipy.model.customer.service;

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
		IModelCustomerDao customerDao = (IModelCustomerDao) Mockito.mock(IModelCustomerDao.class);
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
		
		CustomerDto customerDto1 = customerService.getCustomer("TEST", "PASSWORD");
		
		Assert.assertNull(customerDto1);
		//Assert.assertEquals("DURAND", customerDto1.getName());
		
	}
	
}
