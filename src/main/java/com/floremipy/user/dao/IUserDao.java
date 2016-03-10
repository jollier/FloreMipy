package com.floremipy.user.dao;

import java.util.List;

import com.floremipy.user.User;
import com.floremipy.user.dto.UserDto;

public interface IUserDao {

	List<UserDto> findAllUsers();

	UserDto findUserByUserName(String userName);

	List<UserDto> findUserByUserType(String userType);

	UserDto findUserByUserNameAndPassword(String userName, String password);
	
	UserDto createNewUser(UserDto newUserDto);
	
	void updateUser (UserDto userDto);

	void deleteUser(UserDto userDto);

}