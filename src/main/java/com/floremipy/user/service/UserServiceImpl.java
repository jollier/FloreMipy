package com.floremipy.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.floremipy.user.User;
import com.floremipy.user.dao.UserDao;

public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	public List<User> getAll() {
		//Changer le return dès que le Dao sera OK
		//userDao.findAll()
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

	public boolean save(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
