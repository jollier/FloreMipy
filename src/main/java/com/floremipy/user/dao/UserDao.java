package com.floremipy.user.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.floremipy.user.dto.UserDto;

public class UserDao implements Serializable, IUserDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6181515256377426679L;
	private final static String PERSISTENCE_UNIT_NAME = "floremipyuser";
	private static EntityManagerFactory emf;	
	private static EntityManager em;	

	public UserDao() {
		//		super();
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
	}

	/* (non-Javadoc)
	 * @see com.floremipy.user.dao.IUserDao#findAllUsers()
	 */
	public List<UserDto> findAllUsers(){
		String requete = 
				"SELECT NEW com.floremipy.user.dto.UserDto(" + 
						"u.id, u.username, u.password, u.firstname, u.lastname, u.usertype) " +
						"FROM User u order by u.username" ;
		Query query = null;
		query = em.createQuery(requete, UserDto.class);
		return (List<UserDto>)query.getResultList();
	}

	/* (non-Javadoc)
	 * @see com.floremipy.user.dao.IUserDao#findUserByUserName(java.lang.String)
	 */
	public UserDto findUserByUserName(String userName) {
		String requete = 
				"Select NEW com.floremipy.user.dto.UserDto(" + 
						"u.id, u.username, u.password, u.firstname, u.lastname, u.usertype) " +
						"FROM User u where u.username = :username" ;
		Query query = em.createQuery(requete, UserDto.class);;
		query.setParameter("username", userName);
		return (UserDto)query.getSingleResult();
	}
	
	/* (non-Javadoc)
	 * @see com.floremipy.user.dao.IUserDao#findUserByUserType(java.lang.String)
	 */
	public List<UserDto> findUserByUserType(String userType){
		String requete = 
				"SELECT NEW com.floremipy.user.dto.UserDto(" + 
						"u.id, u.username, u.password, u.firstname, u.lastname, u.usertype) " +
						"FROM User u where lower(u.usertype) = :usertype order by u.username" ;
		Query query = null;
		query = em.createQuery(requete, UserDto.class);
		query.setParameter("usertype", userType.toLowerCase());
		return (List<UserDto>)query.getResultList();
	}
}
