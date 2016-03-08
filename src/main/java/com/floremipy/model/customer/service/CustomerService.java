package com.floremipy.model.customer.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.floremipy.model.Customer;
import com.floremipy.model.customer.dao.IModelCustomerDao;
import com.floremipy.model.customer.dto.CustomerDto;
import com.floremipy.user.User;
import com.floremipy.user.dao.IUserDao;
import com.floremipy.user.dao.UserDao;
import com.floremipy.user.dto.UserDto;

public class CustomerService {
	
	@Autowired
	IModelCustomerDao customerDao;
	
	@Autowired
	IUserDao userDao;
	
	
	
	public void setCustomerDao(IModelCustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void save(Customer customer) {
		//customerDao.save(customer);
	}
	
	public CustomerDto getCustomer(String login, String password){
		UserDto userDto = userDao.findUserByUserNameAndPassword(login, password);
		CustomerDto customerDto = null;
		if (userDto != null){
			//customerDto = customerDao.findCustomerById(userDto.getIdcustomer());
		}
		return customerDto;
	}
	
}
