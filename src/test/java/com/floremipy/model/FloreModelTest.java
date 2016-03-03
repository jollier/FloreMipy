package com.floremipy.model;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.floremipy.model.dao.ModelDao;
import com.floremipy.model.dto.ArticleDto;

public class FloreModelTest {
	
	private final static String PERSISTENCE_UNIT_NAME = "FloreMipyWeb";
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	public static EntityManager em = emf.createEntityManager();
	public static EntityTransaction transaction = em.getTransaction();

	@Test
	public void testFindAllArticles() {
		ModelDao modelDao = new ModelDao();
		List<ArticleDto> resultArticle = modelDao.findAllArticles();
		for(ArticleDto a : resultArticle){
			System.out.println("result test FindAllArticles : " +a);
		}	
		assertTrue(resultArticle.size() > 0);
	}
	
	@Test
	

}
