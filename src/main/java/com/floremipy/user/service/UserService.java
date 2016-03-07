package com.floremipy.user.service;

import java.util.List;

import com.floremipy.user.User;

public class UserService implements IUserService{


	public List<User> getAll() {
		//Changer le return dès que le Dao sera OK
		//return userDao.findAllUsers();
		return null;
	}

	public User getUser() {
		//Changer le return dès que le Dao sera OK
		//userDao.findOne()
		return null;
	}

	public User getUserById() {
		Long id = 1L;
		//Changer le return dès que le Dao sera OK
		//userDao.findById(id);
		return null;
	}

	public boolean delUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public void save(User user) {
		// TODO Auto-generated method stub
	}
	
	
}
