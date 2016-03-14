
package com.floremipy.model.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floremipy.model.Customer;
import com.floremipy.model.customer.dao.IModelCustomerDao;
import com.floremipy.model.customer.dto.CustomerDto;
import com.floremipy.user.dao.IUserDao;
import com.floremipy.user.dto.UserDto;

@Service
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
	public void save(Customer customer, UserDto userDto) {
		userDao.createNewUser(userDto);
		customerDao.CustomerDaoSave(customer);
	}
	
	@Override
	public CustomerDto getCustomerByLoginAndPassword(String login, String password){
		CustomerDto customerDto = null;
		UserDto userDto = userDao.findUserByUserNameAndPassword(login, password);
		
		if ((userDto != null) && (userDto.getIdcustomer() > 0)){
			customerDto = customerDao.findCustomerById(userDto.getIdcustomer());
		}
		return customerDto;
	}

	@Override
	public List<CustomerDto> findAllCustomers() {
		return customerDao.findAllCustomers();
	}

}
