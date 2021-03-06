package com.floremipy.model.customer.dao;

import java.util.List;

import com.floremipy.model.customer.dto.CustomerDto;


public interface IModelCustomerDao {
	
	String FindNameLastCustomer();

	CustomerDto CustomerDaoSave (CustomerDto customerDto);
	List<CustomerDto> findAllCustomers();
	CustomerDto findCustomerById(int id);
	CustomerDto findCustomerByEmail(String email);
}
