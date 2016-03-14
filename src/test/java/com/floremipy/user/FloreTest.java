package com.floremipy.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.floremipy.user.dao.IUserDao;
import com.floremipy.user.dao.UserDao;
import com.floremipy.user.dto.UserDto;




public class FloreTest {

	private final static String PERSISTENCE_UNIT_NAME = "floremipyuser";
	public static EntityManagerFactory emf;
	public static EntityManager em;
	public static EntityTransaction transaction;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		int versionBaseUser = 6;
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em =  emf.createEntityManager();
		UserDbVersion version = em.find(UserDbVersion.class, 1);
		
		if (version.getVersion() != versionBaseUser) {
			System.out.println("");
			System.out.println("");
			System.out.println("********************************");
			System.out.println("**Version de la BDD floremipyuser incorrecte**");
			System.out.println("********************************");
			System.out.println("Veuillez l'importer depuis srv-dev/PARTAGES/FloreMipy-2016-02-29/FloreMipy/FloreMipiUsers.sql");
			System.exit(1);
		}
		
	}



	@Test
	public void testFindAllUsers() { 
		IUserDao userDao = new UserDao();
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
		IUserDao userDao = new UserDao();
		UserDto user = userDao.findUserByUserName(userName);
		System.out.println("result test FindUserByUserName : " +user.toString());
		assertEquals(userName, user.getUsername());
	}

	@Test
	public void testFindAdminUsers() {
		String userType="Admin";
		IUserDao userDao = new UserDao();
		List<UserDto> resultUser = userDao.findUserByUserType(userType);
		for(UserDto a : resultUser){
			System.out.println("result test FindAdminUsers('" + userType + "'): " +a);
		}	
		assertTrue(resultUser.size() >= 0);
	}

	@Test
	public void testFindUserUsers() {
		String userType="User";
		IUserDao userDao = new UserDao();
		List<UserDto> resultUser = userDao.findUserByUserType(userType);
		for(UserDto a : resultUser){
			System.out.println("result test FindUserUsers('" + userType + "'): " +a);
		}	
		assertTrue(resultUser.size() >= 0);
	}

	@Test
	public void testFindUserByUserNameAndPassword() {
		String userName = "user1";
		String password = "user1";
		IUserDao userDao = new UserDao();
		UserDto user = userDao.findUserByUserNameAndPassword(userName, password);
		System.out.println("result test FindUserByUserNameAndPassword : " +user.toString());
		assertEquals(userName, user.getUsername());
	}

	@Test
	public void testCreateNewUser() {
		IUserDao userDao = new UserDao();
		int i = 0;
		String userName = "";
		UserDto userExists = null;
		do {
			i++;
			userName = "testCreateUser" + i;
			userExists = userDao.findUserByUserName(userName);
		} while (userExists != null);

		UserDto userDto = new UserDto(null,userName, userName, "user", 1);

		UserDto newUser = userDao.createNewUser(userDto);
		System.out.println("result test testCreateNewUser : " +newUser.toString());
		assertTrue(newUser.getId() != 0L);
	}
	
	@Test
	public void testUpdateUser(){
		LocalDateTime localDateTime = LocalDateTime.now();
//		Date date = Date.from(localDateTime.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		String name = "testupdateUser " + localDateTime.toString();
		IUserDao userDao = new UserDao();
		String usertype = "user";
		UserDto userDto = new UserDto(null,name, name, usertype, 2);
		UserDto newUserDto = userDao.createNewUser(userDto);
		name = name + "Update";		
		newUserDto.setUsername(name);
		userDao.updateUser(newUserDto);		
		UserDto verifyUser = userDao.findUserByUserName(name);
		assertEquals(verifyUser.getUsername(),name);
				
	}
	
	@Test
	public void testDeleteUser(){
		IUserDao userDao = new UserDao();
		String name = "";
		name = "testUserDelete" ;
		UserDto userDto = new UserDto(null,name, name, name,   1);
		UserDto newUserDto = userDao.createNewUser(userDto);
		System.out.println("result test testDeleteNewUser : " + newUserDto.toString());
		userDao.deleteUser(newUserDto);		
		assertTrue(userDao.findUserByUserName(name) == null);
	}



	@AfterClass
	public static void setUpAfterClass() throws Exception {
		em.close();
		emf.close();
	}


}