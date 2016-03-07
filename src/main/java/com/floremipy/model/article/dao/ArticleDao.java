package com.floremipy.model.article.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.floremipy.model.Article;
import com.floremipy.model.article.dto.ArticleDto;
import com.floremipy.model.article.dto.ArticleLightDto;


public class ArticleDao implements Serializable, IArticleDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3203724104256506631L;
	private final static String PERSISTENCE_UNIT_NAME = "FloreMipyWeb";
	private static EntityManagerFactory emf;	
	private static EntityManager em;	

	public ArticleDao() {
		//		super();
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
	}
	
	/* (non-Javadoc)
	 * @see com.floremipy.model.article.dao.IModelArticleDao#findAllArticles()
	 */
	public List<ArticleDto> findAllArticles() {
		String requete = 
				"SELECT NEW com.floremipy.model.article.dto.ArticleDto(" + 
						"a.id, a.category, a.description, a.imgsrc, a.name, a.quantityInStock) " +
						"FROM Article a order by a.name" ;
		Query query = null;
		query = em.createQuery(requete, ArticleDto.class);
		return (List<ArticleDto>)query.getResultList();
	}
	
	/* (non-Javadoc)
	 * @see com.floremipy.model.article.dao.IModelArticleDao#findArticleById(int)
	 */
	public ArticleDto findArticleById(int id) {
		String requete = 
				"SELECT NEW com.floremipy.model.article.dto.ArticleDto(" + 
						"a.id, a.category, a.description, a.imgsrc, a.name, a.quantityInStock) " +
						"FROM Article a where a.id = :id" ;
		Query query = null;
		query = em.createQuery(requete, ArticleDto.class);
		query.setParameter("id", id);
		return (ArticleDto)query.getSingleResult();
	}
	
	/* (non-Javadoc)
	 * @see com.floremipy.model.article.dao.IModelArticleDao#findArticleLightById(int)
	 */
	public ArticleLightDto findArticleLightById(int id) {
		String requete = 
				"SELECT NEW com.floremipy.model.article.dto.ArticleLightDto(" + 
						"a.id, a.category, a.description, a.name, a.quantityInStock, p.value) " +
						"FROM Price p, Article a where a.id = :id and a=p.article" ;
		Query query = null;
		query = em.createQuery(requete, ArticleLightDto.class);
		query.setParameter("id", id);
		return (ArticleLightDto)query.getSingleResult();
	}
	
	
	/* (non-Javadoc)
	 * @see com.floremipy.model.article.dao.IModelArticleDao#findAllArticlesLightByCategory(java.lang.String)
	 */
	public List<ArticleLightDto> findAllArticlesLightByCategory(String category) {
		String requete = 
				"SELECT NEW com.floremipy.model.article.dto.ArticleLightDto(" + 
						"a.id, a.category, a.description, a.name, a.quantityInStock, p.value) " +
						"FROM Price p, Article a where Upper(a.category) = :category and a=p.article" ;
		Query query = null;
		query = em.createQuery(requete, ArticleLightDto.class);
		query.setParameter("category", category.toUpperCase());
		return (List<ArticleLightDto>)query.getResultList();
	}
	
	/* (non-Javadoc)
	 * @see com.floremipy.model.article.dao.IModelArticleDao#findAllArticlesLight()
	 */
	public List<ArticleLightDto> findAllArticlesLight() {
		String requete = 
				"SELECT NEW com.floremipy.model.article.dto.ArticleLightDto(" + 
						"a.id, a.category, a.description, a.name, a.quantityInStock, p.value) " +
						"FROM Price p, Article a where a=p.article order by a.name" ;
		Query query = null;
		query = em.createQuery(requete, ArticleLightDto.class);
		return (List<ArticleLightDto>)query.getResultList();
	}
	
	public ArticleDto findArticleByName(String name) {
		String requete = 
				"SELECT NEW com.floremipy.model.article.dto.ArticleDto(" + 
						"a.id, a.name, a.description, a.category, a.imgsrc, a.quantityInStock) " +
						"FROM Article a where a.name = :name" ;
		Query query = null;
		query = em.createQuery(requete, ArticleDto.class);
		query.setParameter("name", name);
		ArticleDto result = null;
		try {
			 result = (ArticleDto)query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			result = null;
		}
		return result;
	}
	
	public ArticleDto createNewArticle(ArticleDto newArticle) {
		em.getTransaction().begin();
		Article article = new Article();
		article.setName(newArticle.getName());
		article.setQuantityInStock(newArticle.getQuantityInStock());
		article.setDescription(newArticle.getDescription());
		article.setCategory(newArticle.getCategory());
		em.persist(article);
		em.getTransaction().commit();
		return (ArticleDto)findArticleByName(newArticle.getName());
	}
	
}