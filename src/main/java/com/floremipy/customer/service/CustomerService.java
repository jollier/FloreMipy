package com.floremipy.customer.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.floremipy.customer.dao.CustomerDao;
import com.floremipy.customer.dao.ICustomerDao;
import com.floremipy.customer.dto.CustomerDto;
import com.floremipy.model.Customer;
import com.floremipy.user.User;
import com.floremipy.user.dao.IUserDao;
import com.floremipy.user.dao.UserDao;
import com.floremipy.user.dto.UserDto;

public class CustomerService {
	
	@Autowired
	ICustomerDao customerDao;
	
	@Autowired
	IUserDao userDao;
	
	
	
	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void save(Customer customer) {
		//customerDao.save(customer);
	}
	
	public CustomerDto getCustomer(String login, String password){
		UserDto userDto = userDao.findUserByNameAndPassword(login, password);
		CustomerDto customerDto = customerDao.findCustomerById(userDto.getIdcustomer());
		return customerDto;
	}
	
}
