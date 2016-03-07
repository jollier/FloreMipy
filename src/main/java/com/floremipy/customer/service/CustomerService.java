package com.floremipy.customer.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.floremipy.model.Customer;
import com.floremipy.user.User;
import com.floremipy.user.dao.UserDao;
import com.floremipy.user.dto.UserDto;

public class CustomerService {
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	UserDao userDao;
	
	public void save(Customer customer) {
		customerDao.save(customer);
	}
	
	public CustomerDto getCustomer(String login, String password){
		UserDto userDto = userDao.findUserByUserNameAndPassword(login, password);
		CustomerDto customerDto = customerDao.findCustomerById(userDto.getIdcustomer());
		return customerDto;
	}
	
}
