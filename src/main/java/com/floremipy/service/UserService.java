package com.floremipy.service;

public interface UserService {
	
	public List<User> getAll();
	
	public User getUser();
	
	public User getUserById();
	
	public boolean delUser(User user);
	
	public boolean save(User user);
}
