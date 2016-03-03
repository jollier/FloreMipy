package com.floremipy.user.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.floremipy.user.dto.UserDto;

public class UserDao {
	private final static String PERSISTENCE_UNIT_NAME = "floremipyuser";
	private static EntityManagerFactory emf;	
	private static EntityManager em;	

	public UserDao() {
		//		super();
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
	}

	public List<UserDto> findAllUsers(){
		String requete = 
				"SELECT NEW com.floremipy.user.dto.UserDto(u.firstname, u.lastname) " +
				" FROM User u order by u.firstname" ;
		Query query = null;
		try {
			query = em.createQuery(requete, UserDto.class);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return (List<UserDto>)query.getResultList();
	}

}
