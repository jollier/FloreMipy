package com.floremipy.model.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.floremipy.model.Customer;
import com.floremipy.model.customer.dao.IModelCustomerDao;
import com.floremipy.model.customer.dto.CustomerDto;
import com.floremipy.user.dao.IUserDao;
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

	@Override
	public void save(Customer customer) {
		customerDao.CustomerDaoSave(customer);
	}
	
	@Override
	public CustomerDto getCustomer(String login, String password){
		UserDto userDto = userDao.findUserByUserNameAndPassword(login, password);
		CustomerDto customerDto = null;
		if ((userDto != null) && (userDto.getIdcustomer()>0)){
			//customerDto = customerDao.findCustomerById(userDto.getIdcustomer());
		}
		return customerDto;
	}

	@Override
	public List<CustomerDto> findAll() {
		// TODO Auto-generated method stub
		return customerDao.findAllCustomers();
	}

}
