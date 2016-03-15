package com.floremipy.model.customer.service;

import java.util.List;

import com.floremipy.model.customer.dto.CustomerDto;


public interface ICustomerService {
	
	CustomerDto save(CustomerDto customerDto);
	
	CustomerDto getCustomerByLoginAndPassword(String login, String password);
	
	List<CustomerDto> findAllCustomers();  
	
	CustomerDto getCustomerByEmail(String email);
	
}
