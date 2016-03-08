package com.floremipy.model.customer.service;

import java.util.List;

import com.floremipy.model.Customer;
import com.floremipy.model.customer.dto.CustomerDto;
import com.floremipy.model.customer.dto.CustomerLightDto;

public interface ICustomerService {
	
	int FindIdLastCustomer();
	void CustomerDaoSave (Customer customer);
	List<CustomerDto> findAllCustomers();
	CustomerDto findCustomerById(int id);
	List<CustomerLightDto> findAllCustomersLight();
	CustomerLightDto findCustomerLightById(int id);
	

}
