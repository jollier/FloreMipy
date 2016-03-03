package com.floremipy.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

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
			System.out.println(a);
		}	
	}
	
	@Test
	public void testFindFirstUser() {
		System.out.println("test");
		User firstUser = em.find(User.class, new Long(1));
		System.out.println(firstUser);
	}
}