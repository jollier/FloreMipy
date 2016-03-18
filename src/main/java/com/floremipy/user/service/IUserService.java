package com.floremipy.user.service;

import java.util.List;

import com.floremipy.user.User;
import com.floremipy.user.dto.UserDto;

public interface IUserService {
	
	public List<User> getAll();
	
	public UserDto getUserByName(String name);
	
	public User getUserById();
	
	public boolean delUser(User user);
	
	public void save(UserDto userDto);

	public void update(UserDto userDto);
	
	public UserDto create(UserDto userDto);
}
