package com.floremipy.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceProviderResolver;
import javax.persistence.spi.PersistenceProviderResolverHolder;

import org.junit.BeforeClass;
import org.junit.Test;


public class FloreTest {
	
	private final static String PERSISTENCE_UNIT_NAME = "floremipyuser";
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	public static EntityManager em = emf.createEntityManager();
	public static EntityTransaction transaction = em.getTransaction();


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	
	
//	@Test
	public void testFindAllUsers() {
//		transaction.begin();
//		
//		List<UserDto> resultUser = UserDao.findAllUsers();
//		for(UserDto a : resultUser){
//			System.out.println(a);
//		}	

	}
	
	@Test
	public void testFindFirstUser() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction transaction = em.getTransaction();
		System.out.println("test");
		User firstUser = em.find(User.class, new Long(1));
		System.out.println(firstUser);
//		emf.close();
//		em.close();
	}
}