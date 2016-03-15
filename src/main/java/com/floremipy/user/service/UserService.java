package com.floremipy.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floremipy.user.User;
import com.floremipy.user.dao.IUserDao;
import com.floremipy.user.dto.UserDto;

@Service
public class UserService implements IUserService{

	@Autowired
	IUserDao userDao;

	public List<User> getAll() {
		//Changer le return dès que le Dao sera OK
		//return userDao.findAllUsers();
		return null;
	}

	public UserDto getUserByName(String name) {
		//Changer le return dès que le Dao sera OK
		return userDao.findUserByUserName(name);
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

	public void save(UserDto userDto) {
		userDao.updateUser(userDto);
	}
	
	public UserDto create(UserDto userDto) {
		return userDao.createNewUser(userDto);
	}
	
}
