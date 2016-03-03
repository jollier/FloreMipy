package com.floremipy.user;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.floremipy.user.dao.UserDao;
import com.floremipy.user.dto.UserDto;

import junit.framework.Assert;


public class FloreTest {
	
	private final static String PERSISTENCE_UNIT_NAME = "floremipyuser";
	public static EntityManagerFactory emf;
	public static EntityManager em;
	public static EntityTransaction transaction;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em =  emf.createEntityManager();
		transaction =  em.getTransaction();
	}

	
	
	@Test
	public void testFindAllUsers() {
		UserDao userDao = new UserDao();
		List<UserDto> resultUser = userDao.findAllUsers();
		for(UserDto a : resultUser){
			System.out.println("result test FindAllUsers : " +a);
		}	
		assertNotEquals(resultUser.size(), 0);
	}
	
	@Test
	public void testFindFirstUser() {	
		User firstUser = em.find(User.class, new Long(1));
		System.out.println("FirstUser :" + firstUser.toString());
		assertNotNull(firstUser);
	}
	
	@AfterClass
	public static void setUpAfterClass() throws Exception {
	em.close();
	emf.close();
	}
}