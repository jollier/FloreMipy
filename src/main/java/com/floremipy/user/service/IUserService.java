package com.floremipy.user.service;

import java.util.List;

import com.floremipy.user.User;
import com.floremipy.user.dto.UserDto;

public interface IUserService {
	
	public List<UserDto> getAll();
	
	public UserDto getUser(String userName);
		
	public boolean delUser(User user);
	
	public void save(User user);
}
