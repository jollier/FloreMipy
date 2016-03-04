package com.floremipy.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import com.floremipy.user.dao.UserDao;
import com.floremipy.user.dto.UserDto;


public class FloreTest {
	
	private final static String PERSISTENCE_UNIT_NAME = "floremipyuser";
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	public static EntityManager em = emf.createEntityManager();
	public static EntityTransaction transaction = em.getTransaction();


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	
	
	@Test
	public void testFindAllUsers() { 
		UserDao userDao = new UserDao();
		List<UserDto> resultUser = userDao.findAllUsers();
		for(UserDto a : resultUser){
			System.out.println("result test FindAllUsers : " +a);
		}	
		assertTrue(resultUser.size() > 0);
	}
	
	@Test
	public void testFindFirstUser() {	
		User firstUser = em.find(User.class, new Long(1));
		System.out.println("FirstUser :" + firstUser.toString());
		assertTrue(firstUser.getId() >= 0);
	}
	
	@Test
	public void testFindUserById() {
		Long id = 1L;
		User user =em.find(User.class, id);
		assertEquals(id,user.getId());
	}
	
	@Test
	public void testFindUserByUserName() {
		String userName = "user1";
		UserDao userDao = new UserDao();
		UserDto user = userDao.findUserByUserName(userName);
		System.out.println("result test FindUserByUserName : " +user.toString());
		assertEquals(userName, user.getUsername());
	}
	
	@Test
	public void testFindAdminUsers() {
		String userType="Admin";
		UserDao userDao = new UserDao();
		List<UserDto> resultUser = userDao.findUserByUserType(userType);
		for(UserDto a : resultUser){
			System.out.println("result test FindAdminUsers('" + userType + "'): " +a);
		}	
		assertTrue(resultUser.size() >= 0);
	}
	
	@Test
	public void testFindUserUsers() {
		String userType="User";
		UserDao userDao = new UserDao();
		List<UserDto> resultUser = userDao.findUserByUserType(userType);
		for(UserDto a : resultUser){
			System.out.println("result test FindUserUsers('" + userType + "'): " +a);
		}	
		assertTrue(resultUser.size() >= 0);
	}
	
	
}