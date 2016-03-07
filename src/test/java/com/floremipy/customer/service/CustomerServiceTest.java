package com.floremipy.customer.service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.floremipy.user.dao.UserDao;
import com.floremipy.user.dto.UserDto;

public class CustomerServiceTest {

	@Test
	public void testGetCustomerByLoginAndPassword(){
		CustomerDao customerDao = Mockito.mock(CustomerDao.class);
		UserDao userDao = Mockito.mock(UserDao.class);
		
		CustomerDto customerDto = new CustomerDto();
		customerDto.setName("DURAND");
		
		UserDto userDto = new UserDto();
		userDto.setLastname("TEST");
		userDto.setFirstname("JEAN");
		
		Mockito.when(customerDao.findCustomerById(1)).thenReturn(customerDto);
		Mockito.when(userDao.findUserByUserNameAndPassword("TEST","PASSWORD")).thenReturn(userDto);
		CustomerService customerService = new CustomerService();
		CustomerDto customerDto = (CustomerDto) customerService.getCustomer("TEST", "PASSWORD");
		
		Assert.assertEquals("DURAND", customerDto.getName());
		
	}
	
}
