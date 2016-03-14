package com.floremipy.user.service;

import java.util.List;

import com.floremipy.user.User;
import com.floremipy.user.dto.UserDto;

public interface IUserService {
	
	public List<User> getAll();
	
	public User getUser();
	
	public User getUserById();
	
	public boolean delUser(User user);
	
	public UserDto save(UserDto userDto);
}
