package com.floremipy.user.service;

import java.util.List;

import com.floremipy.user.User;

public interface UserService {
	
	public List<User> getAll();
	
	public User getUser();
	
	public User getUserById();
	
	public boolean delUser(User user);
	
	public void save(User user);
}
