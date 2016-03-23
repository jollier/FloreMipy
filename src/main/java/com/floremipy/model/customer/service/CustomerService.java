
package com.floremipy.model.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floremipy.model.customer.dao.IModelCustomerDao;
import com.floremipy.model.customer.dto.CustomerDto;
import com.floremipy.user.dao.IUserDao;
import com.floremipy.user.dto.UserDto;
import com.floremipy.user.service.IUserService;


@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	IModelCustomerDao customerDao;
	
	@Autowired
	IUserDao userDao;
	
	@Autowired
	IUserService userService;
	
	public void setCustomerDao(IModelCustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public String save(CustomerDto customerDto, UserDto userDto) {
		String message = "";
		
		try {
			// 1. Sauvegarde du user
			UserDto userDtoSave = userService.create(userDto);
			// 2. Sauvegarde du customer
			CustomerDto customerDtoSave = customerDao.CustomerDaoSave(customerDto);
			// 3. Mise à jour de l'id customer
			userDtoSave.setIdcustomer(customerDtoSave.getId());
			// 4. Enregistrement de ce nouveau UserDto avec l'id du customer
			userService.save(userDtoSave);		
		} catch (Exception e) {
			e.printStackTrace();
			message = "Problème lors de la sauvegarde de l'utilisateur. Veuillez contacter votre SAV !";
		}	
		return message;
	}
	
	@Override
	public String update(CustomerDto customerDto, UserDto userDto) {
		String message = "";
		
		try {
			// 1. Update du user
			userService.update(userDto);
			// 2. Update du customer
			customerDao.CustomerDaoUpdate(customerDto);

		} catch (Exception e) {
			e.printStackTrace();
			message = "Problème lors de la sauvegarde de l'utilisateur. Veuillez contacter votre SAV !";
		}	
		return message;
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

	@Override
	public CustomerDto getCustomerByEmail(String email){
		return customerDao.findCustomerByEmail(email);
	}

	@Override
	public CustomerDto getCustomerById(int id){
		return customerDao.findCustomerById(id);
				}
}
