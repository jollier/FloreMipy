package com.floremipy.service;

import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	public List<User> getAll() {
		return userDao.findAll();
	}

	public User getUser() {
		return userDao.findOne();
	}

	public User getUserById() {
		Long id = 1L; 
		return userDao.findById(id);
	}

	public boolean delUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean save(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
