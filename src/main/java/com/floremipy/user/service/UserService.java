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
	
	@Override
	public List<UserDto> getAll() {
		return userDao.findAllUsers();
	}

	@Override
	public UserDto getUser(String userName) {
		return userDao.findUserByUserName(userName);
	}

	@Override
	public boolean delUser(User user) {
		// not implemented
		return false;
	}

	@Override
	public void save(User user) {
		// not implemented
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	
}
