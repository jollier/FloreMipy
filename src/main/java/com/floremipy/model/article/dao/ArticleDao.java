package com.floremipy.model.article.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.floremipy.model.Article;
import com.floremipy.model.article.dto.ArticleDto;

@Component
public class ArticleDao implements IArticleDao{
	/**
	 * 
	 */
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
	@SuppressWarnings("unchecked")
	public List<ArticleDto> findAllArticles() {
		String requete = 
				"SELECT NEW com.floremipy.model.article.dto.ArticleDto(" + 
						"a.id, a.category, a.description, a.imgsrc, a.name, a.quantityInStock) " +
						"FROM Article a ORDER BY a.name" ;
		Query query = null;
		query = em.createQuery(requete, ArticleDto.class);
		List<ArticleDto> result = null;
		try {
			result = (List<ArticleDto>)query.getResultList(); 
		} catch (Exception e) {
			// TODO: handle exception
			result = null;
		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.floremipy.model.article.dao.IModelArticleDao#findArticleById(int)
	 */
	public ArticleDto findArticleById(int id) {
		String requete = 
				"SELECT NEW com.floremipy.model.article.dto.ArticleDto(" + 
						"a.id, a.category, a.description, a.imgsrc, a.name, a.quantityInStock) " +
						"FROM Article a WHERE a.id = :id" ;
		Query query = null;
		query = em.createQuery(requete, ArticleDto.class);
		query.setParameter("id", id);
		ArticleDto result = null;
		try {
			result = (ArticleDto)query.getSingleResult();
		} catch (Exception e) {
			result = null;
			// TODO: handle exception
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<ArticleDto> findAllArticlesByCategory(String category) {
		String requete = 
				"SELECT NEW com.floremipy.model.article.dto.ArticleDto(" + 
						"a.id, a.category, a.description, a.imgsrc, a.name, a.quantityInStock) " +
						"FROM Article a WHERE Upper(a.category) = :category" ;
		Query query = null;
		query = em.createQuery(requete, ArticleDto.class);
		query.setParameter("category", category.toUpperCase());
		List<ArticleDto> result = null;
		try {
			result = (List<ArticleDto>)query.getResultList(); 
		} catch (Exception e) {
			result = null;
			// TODO: handle finally clause
		}
		return result;
	}
	
	public ArticleDto findArticleByName(String name) {
		String requete = 
				"SELECT NEW com.floremipy.model.article.dto.ArticleDto(" + 
						"a.id, a.category, a.description, a.imgsrc, a.name, a.quantityInStock) " +
						"FROM Article a WHERE Upper(a.name) = :name" ;
		Query query = null;
		query = em.createQuery(requete, ArticleDto.class);
		query.setParameter("name", name.toUpperCase());
		ArticleDto result = null;
		try {
			 result = (ArticleDto)query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception 
			//e.printStackTrace();
			result = null;
		}
		return result;
	}
	
	public ArticleDto createArticle(ArticleDto newArticle) {
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
	
	public void deleteArticle(ArticleDto articleDto) {
		Article article = em.find(Article.class, articleDto.getId());
		em.getTransaction().begin();
		em.remove(article);
		em.getTransaction().commit();
	}
	
	public void updateArticle(ArticleDto articleDto) {
		Article article = em.find(Article.class, articleDto.getId());
		article.setCategory(articleDto.getCategory());
		article.setDescription(articleDto.getDescription());
		article.setImgsrc(articleDto.getImgsrc());
		article.setName(articleDto.getName());
		em.getTransaction().begin();
		em.merge(article);
		em.persist(article);
		em.getTransaction().commit();
	}
	
		
}