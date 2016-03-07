package com.floremipy.customer.service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.floremipy.customer.dao.ICustomerDao;
import com.floremipy.customer.dto.CustomerDto;
import com.floremipy.user.dao.UserDao;
import com.floremipy.user.dto.UserDto;

public class CustomerServiceTest {

	@Test
	public void testGetCustomerByLoginAndPassword(){
		ICustomerDao customerDao = (ICustomerDao) Mockito.mock(ICustomerDao.class);
		UserDao userDao = Mockito.mock(UserDao.class);
		
		CustomerDto customerDto = new CustomerDto();
		customerDto.setName("DURAND");
		
		UserDto userDto = new UserDto();
		userDto.setLastname("TEST");
		userDto.setFirstname("JEAN");
		userDto.setIdcustomer(1L);
		
		Mockito.when(customerDao.findCustomerById(1L)).thenReturn(customerDto);
		Mockito.when(userDao.findUserByNameAndPassword("TEST","PASSWORD")).thenReturn(userDto);
		
		CustomerService customerService = new CustomerService();
		customerService.setCustomerDao(customerDao);
		customerService.setUserDao(userDao);
		
		CustomerDto customerDto1 = customerService.getCustomer("TEST", "PASSWORD");
		
		Assert.assertEquals("DURAND", customerDto1.getName());
		
	}
	
}
