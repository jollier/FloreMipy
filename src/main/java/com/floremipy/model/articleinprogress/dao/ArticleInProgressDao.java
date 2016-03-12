package com.floremipy.model.articleinprogress.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.floremipy.model.Article;
import com.floremipy.model.Articleinprogress;
import com.floremipy.model.articleinprogress.dto.ArticleInProgressDto;

@Component
public class ArticleInProgressDao implements IArticleInProgressDao {

	private final static String PERSISTENCE_UNIT_NAME = "FloreMipyWeb";
	private static EntityManagerFactory emf;	
	private static EntityManager em;	

	public ArticleInProgressDao() {
		//		super();
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
	}
	
	/* (non-Javadoc)
	 * @see com.floremipy.model.price.dao.IPriceDao#findPriceByArticleId(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleInProgressDto> findArticleInProgressByArticleId(int id) {
		String requete = 
				"SELECT NEW com.floremipy.model.articleinprogress.dto.ArticleInProgressDto(" + 
						"aip.id, aip.quantity, aip.startDate, aip.releaseDate, aip.article.id) " +
						"FROM Articleinprogress aip WHERE aip.article.id = :id" ;
		Query query = null;
		query = em.createQuery(requete, ArticleInProgressDto.class);
		query.setParameter("id", id);
		List<ArticleInProgressDto> result = null;
		try {
			result = (List<ArticleInProgressDto>)query.getResultList(); 
		} catch (Exception e) {
			result = null;
			// TODO: handle finally clause
		}
		return result;
		
	}
	
	@Override
	public ArticleInProgressDto findArticleInProgressById(int id) {
		String requete = 
				"SELECT NEW com.floremipy.model.articleinprogress.dto.ArticleInProgressDto(" + 
						"aip.id, aip.quantity, aip.startDate, aip.releaseDate, aip.article.id) " +
						"FROM Articleinprogress aip WHERE aip.id = :id" ;
		Query query = null;
		query = em.createQuery(requete, ArticleInProgressDto.class);
		query.setParameter("id", id);
		ArticleInProgressDto result = null;
		try {
			result = (ArticleInProgressDto)query.getSingleResult(); 
		} catch (Exception e) {
			result = null;
			// TODO: handle finally clause
		}
		return result;
	}
	
	@Override
	public void createArticleInProgressForArticleId(ArticleInProgressDto articleInProgressDto, int idArticle) {
		Article article = em.find(Article.class, idArticle);
		Articleinprogress articleInProgress = new Articleinprogress();
		articleInProgress.setArticle(article);
		articleInProgress.setReleaseDate(articleInProgressDto.getReleaseDate());
		articleInProgress.setQuantity(articleInProgressDto.getQuantity());
		articleInProgress.setStartDate(articleInProgressDto.getStartDate());
		em.getTransaction().begin();
		em.persist(articleInProgress);
		em.getTransaction().commit();
	}
	
	@Override
	public void updateArticleInProgress(ArticleInProgressDto articleInProgressDto) {
		Articleinprogress articleInProgress = em.find(Articleinprogress.class, articleInProgressDto.getId());
		em.getTransaction().begin();
		em.merge(articleInProgress);
		em.persist(articleInProgress);
		em.getTransaction().commit();
	}
	
	
	@Override
	public void deleteArticleInProgress(ArticleInProgressDto articleInProgressDto) {
		Articleinprogress articleInProgress = em.find(Articleinprogress.class, articleInProgressDto.getId());
		em.getTransaction().begin();
		em.remove(articleInProgress);
		em.getTransaction().commit();
	}
}
