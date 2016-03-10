package com.floremipy.user.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.floremipy.model.article.dao.IArticleDao;
import com.floremipy.model.article.dto.ArticleLightDto;
import com.floremipy.model.article.service.ArticleService;
import com.floremipy.user.dao.IUserDao;
import com.floremipy.user.dto.UserDto;

public class UserServiceTest {


	@Test
	public void testfindAllUsersDTO(){
		// *******************************************
		// ****               Arrange             ****
		// *******************************************
		IUserDao userDao = Mockito.mock(IUserDao.class);
		
		UserDto user1 = new UserDto();
		UserDto user2 = new UserDto();
		List<UserDto> liste = new ArrayList<UserDto>();
		liste.add(user1);
		liste.add(user2);
		
		Mockito.when(userDao.findAllUsers()).thenReturn(liste);
		
		UserService userService = new UserService();
		userService.setUserDao(userDao);
		// *****************************************************
		// ****                     Act                     ****
		// *****************************************************
		List<UserDto> list = userService.getAll();
		
		// *****************************************************
		// ****                  Assert                     ****
		// *****************************************************		
		Assert.assertEquals(2, list.size());		
	}
	
	@Test
	public void testfindUserDTOByName_OK(){
		IUserDao userDao = Mockito.mock(IUserDao.class);
		
		UserDto user = new UserDto();
		user.setUsername("TEST");
		
		Mockito.when(userDao.findUserByUserName("TEST")).thenReturn(user);
		
		UserService userService = new UserService();
		userService.setUserDao(userDao);
		
		
		UserDto user2 = userService.getUser("TEST");
		
		Assert.assertEquals(user2, user);
		Assert.assertEquals(UserDto.class, user.getClass());
		
	}
	
	@Test
	public void testfindUserDTOByName_NOK(){
		IUserDao userDao = Mockito.mock(IUserDao.class);
		
		Mockito.when(userDao.findUserByUserName("TEST2")).thenReturn(null);
		
		UserService userService = new UserService();
		userService.setUserDao(userDao);
		
		Assert.assertEquals(null, userService.getUser("TEST"));
		Assert.assertEquals(null, userService.getUser("TEST2"));
	}
}

