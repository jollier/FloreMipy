package com.floremipy.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.floremipy.model.dto.ArticleDto;
import com.floremipy.model.dto.ArticleLightDto;

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
	
	public ArticleDto findArticleById(int id) {
		String requete = 
				"SELECT NEW com.floremipy.model.dto.ArticleDto(" + 
						"a.id, a.category, a.description, a.imgsrc, a.name, a.quantityInStock) " +
						"FROM Article a where a.id = :id" ;
		Query query = null;
		query = em.createQuery(requete, ArticleDto.class);
		query.setParameter("id", id);
		return (ArticleDto)query.getSingleResult();
	}
	
	public ArticleLightDto findArticleLightById(int id) {
		String requete = 
				"SELECT NEW com.floremipy.model.dto.ArticleLightDto(" + 
						"a.id, a.category, a.description, a.name, a.quantityInStock) " +
						"FROM Article a where a.id = :id" ;
		Query query = null;
		query = em.createQuery(requete, ArticleLightDto.class);
		query.setParameter("id", id);
		return (ArticleLightDto)query.getSingleResult();
	}
	
	
	public List<ArticleLightDto> findAllArticlesLightByCategory(String category) {
		String requete = 
				"SELECT NEW com.floremipy.model.dto.ArticleLightDto(" + 
						"a.id, a.category, a.description, a.name, a.quantityInStock) " +
						"FROM Article a where Upper(a.category) = :category" ;
		Query query = null;
		query = em.createQuery(requete, ArticleLightDto.class);
		query.setParameter("category", category.toUpperCase());
		return (List<ArticleLightDto>)query.getResultList();
	}
	
	public List<ArticleLightDto> findAllArticlesLigt() {
		String requete = 
				"SELECT NEW com.floremipy.model.dto.ArticleLightDto(" + 
						"a.id, a.category, a.description, a.name, a.quantityInStock) " +
						"FROM Article a order by a.name" ;
		Query query = null;
		query = em.createQuery(requete, ArticleLightDto.class);
		return (List<ArticleLightDto>)query.getResultList();
	}
	
	
	
	
}
