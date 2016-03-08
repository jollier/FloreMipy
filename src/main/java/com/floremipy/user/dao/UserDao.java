package com.floremipy.user.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.floremipy.user.User;
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
						"u.id, u.username, u.password, u.usertype, u.idcustomer) " +
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
						"u.id, u.username, u.password, u.usertype, u.idcustomer) " +
						"FROM User u where u.username = :username" ;
		Query query = em.createQuery(requete, UserDto.class);;
		query.setParameter("username", userName);
		UserDto result = null;
		try {
			 result = (UserDto)query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			result = null;
		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.floremipy.user.dao.IUserDao#findUserByUserType(java.lang.String)
	 */
	public List<UserDto> findUserByUserType(String userType){
		String requete = 
				"SELECT NEW com.floremipy.user.dto.UserDto(" + 
						"u.id, u.username, u.password, u.usertype, u.idcustomer) " +
						"FROM User u where lower(u.usertype) = :usertype order by u.username" ;
		Query query = null;
		query = em.createQuery(requete, UserDto.class);
		query.setParameter("usertype", userType.toLowerCase());
		return (List<UserDto>)query.getResultList();
	}
	
	public UserDto findUserByUserNameAndPassword(String userName, String password) {
		String requete = 
				"Select NEW com.floremipy.user.dto.UserDto(" + 
						"u.id, u.username, u.password, u.usertype, u.idcustomer) " +
						"FROM User u where u.username = :username and u.password = :password" ;
		Query query = em.createQuery(requete, UserDto.class);;
		query.setParameter("username", userName);
		query.setParameter("password", password);
		return (UserDto)query.getSingleResult();
	}
	
	public UserDto createNewUser(UserDto newUserDto) {
		em.getTransaction().begin();
		User user = new User();
		user.setUsername(newUserDto.getUsername());
		user.setPassword(newUserDto.getPassword());
		user.setUsertype(newUserDto.getUsertype());
		user.setIdcustomer(1L);
		em.persist(user);
		em.getTransaction().commit();
		return findUserByUserName(newUserDto.getUsername());
	}
	
}
