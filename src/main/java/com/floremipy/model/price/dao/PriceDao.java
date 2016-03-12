package com.floremipy.model.price.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.floremipy.model.Article;
import com.floremipy.model.Price;
import com.floremipy.model.price.dto.PriceDto;


@Component
public class PriceDao implements IPriceDao{

	/**
	 * 
	 */

	private final static String PERSISTENCE_UNIT_NAME = "FloreMipyWeb";
	private static EntityManagerFactory emf;	
	private static EntityManager em;	

	public PriceDao() {
		//		super();
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
	}
	
	/* (non-Javadoc)
	 * @see com.floremipy.model.price.dao.IPriceDao#findPriceByArticleId(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PriceDto> findPriceByArticleId(int id) {
		String requete = 
				"SELECT NEW com.floremipy.model.price.dto.PriceDto(" + 
						"p.id, p.article.id, p.date, p.value) " +
						"FROM Price p WHERE p.article.id = :id" ;
		Query query = null;
		query = em.createQuery(requete, PriceDto.class);
		query.setParameter("id", id);
		List<PriceDto> result = null;
		try {
			result = (List<PriceDto>)query.getResultList(); 
		} catch (Exception e) {
			result = null;
			// TODO: handle finally clause
		}
		return result;
		
	}
	
	@Override
	public PriceDto findPriceById(int id) {
		String requete = 
				"SELECT NEW com.floremipy.model.price.dto.PriceDto(" + 
						"p.id, p.article.id, p.date, p.value) " +
						"FROM Price p WHERE p.id = :id" ;
		Query query = null;
		query = em.createQuery(requete, PriceDto.class);
		query.setParameter("id", id);
		PriceDto result = null;
		try {
			result = (PriceDto)query.getSingleResult(); 
		} catch (Exception e) {
			result = null;
			// TODO: handle finally clause
		}
		return result;
	}
	
	@Override
	public void createPriceForArticleId(PriceDto priceDto, int idArticle) {
		Article article = em.find(Article.class, idArticle);
		Price price = new Price();
		price.setDate(priceDto.getDate());
		price.setValue(priceDto.getValue());
		price.setArticle(article);
		em.getTransaction().begin();
		em.persist(price);
		em.getTransaction().commit();
	}
	
	@Override
	public void updatePrice(PriceDto priceDto) {
		Price price = em.find(Price.class, priceDto.getId());
		em.getTransaction().begin();
		em.merge(price);
		em.persist(price);
		em.getTransaction().commit();
	}
	
	
	@Override
	public void deletePrice(PriceDto priceDto) {
		Price price = em.find(Price.class, priceDto.getId());
		em.getTransaction().begin();
		em.remove(price);
		em.getTransaction().commit();
	}
	
}
