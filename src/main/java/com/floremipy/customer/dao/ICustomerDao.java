package com.floremipy.customer.dao;

import com.floremipy.customer.dto.CustomerDto;
import com.floremipy.user.dto.UserDto;

public interface ICustomerDao {

	CustomerDto findCustomerById(Long id);
	
	
}
