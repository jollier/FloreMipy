package com.floremipy.model.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.floremipy.model.Customer;
import com.floremipy.model.customer.dao.IModelCustomerDao;
import com.floremipy.model.customer.dto.CustomerDto;
import com.floremipy.model.customer.dto.CustomerLightDto;
import com.floremipy.user.User;
import com.floremipy.user.dao.IUserDao;
import com.floremipy.user.dao.UserDao;
import com.floremipy.user.dto.UserDto;

public class CustomerService implements ICustomerService {
	
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

	@Override
	public int FindIdLastCustomer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void CustomerDaoSave(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CustomerDto> findAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDto findCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerLightDto> findAllCustomersLight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerLightDto findCustomerLightById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
