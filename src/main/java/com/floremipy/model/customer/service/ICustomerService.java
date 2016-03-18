package com.floremipy.model.customer.service;

import java.util.List;

import com.floremipy.model.customer.dto.CustomerDto;
import com.floremipy.user.dto.UserDto;


public interface ICustomerService {
	
	String save(CustomerDto customerDto, UserDto userDto);

	String update(CustomerDto customerDto, UserDto userDto);
	
	CustomerDto getCustomerByLoginAndPassword(String login, String password);
	
	List<CustomerDto> findAllCustomers();  
	
	CustomerDto getCustomerByEmail(String email);

	CustomerDto getCustomerById(int id);
	
}
