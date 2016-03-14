package com.floremipy.model.customer.dao;

import java.util.List;

import com.floremipy.model.Customer;
import com.floremipy.model.customer.dto.CustomerDto;
import com.floremipy.model.customer.dto.CustomerLightDto;

public interface IModelCustomerDao {
	
	String FindNameLastCustomer();
	Customer CustomerDaoSave (Customer customer);
	List<CustomerDto> findAllCustomers();
	CustomerDto findCustomerById(int id);
	List<CustomerLightDto> findAllCustomersLight();
	CustomerLightDto findCustomerLightById(int id);
	

}
