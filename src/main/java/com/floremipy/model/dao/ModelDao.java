package com.floremipy.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.floremipy.model.dto.ArticleDto;

public class ModelDao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3203724104256506631L;
	private final static String PERSISTENCE_UNIT_NAME = "FloreMipyWeb";
	private static EntityManagerFactory emf;	
	private static EntityManager em;	

	public ModelDao() {
		//		super();
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
	}
	
	public List<ArticleDto> findAllArticles() {
		String requete = 
				"SELECT NEW com.floremipy.model.dto.ArticleDto(" + 
						"a.id, a.category, a.description, a.imgsrc, a.name, a.quantityInStock) " +
						"FROM Article a order by a.name" ;
		Query query = null;
		query = em.createQuery(requete, ArticleDto.class);
		return (List<ArticleDto>)query.getResultList();
	}
}
