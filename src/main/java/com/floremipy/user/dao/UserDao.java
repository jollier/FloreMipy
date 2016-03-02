package com.floremipy.user.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.floremipy.user.dto.UserDto;



public class UserDao implements Serializable{
	
	private final static String PERSISTENCE_UNIT_NAME = "FloreMipyUser";
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);	
	public static EntityManager em = emf.createEntityManager();	
	
	public static List<UserDto> findAllUsers(){
		
		String requete = "SELECT NEW dto.UserDto(u.firstname, u.lastname) " +
				" FROM User u order by u.firstname" ;
				return em.createQuery(requete).getResultList();
		}
	
	
	

}
