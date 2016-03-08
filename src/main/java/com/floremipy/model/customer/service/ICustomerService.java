package com.floremipy.model.customer.service;

import java.util.List;

import com.floremipy.model.Customer;
import com.floremipy.model.customer.dto.CustomerDto;


public interface ICustomerService {
	
		

	void save(Customer customer);
	
	CustomerDto getCustomer(String login, String password);
	
	List<CustomerDto> findAll();  
}