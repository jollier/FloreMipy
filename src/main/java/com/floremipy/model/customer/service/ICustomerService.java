package com.floremipy.model.customer.service;

import java.util.List;

import com.floremipy.model.Customer;
import com.floremipy.model.customer.dto.CustomerDto;
import com.floremipy.user.dto.UserDto;


public interface ICustomerService {
	
	void save(Customer customer, UserDto userDto);
	
	CustomerDto getCustomerByLoginAndPassword(String login, String password);
	
	List<CustomerDto> findAllCustomers();  
}
