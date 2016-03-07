package com.floremipy.model;

import static org.junit.Assert.*;

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
	public void testFindArticleById() {
		int id = 1;
		ModelDao modelDao = new ModelDao();
		ArticleDto resultArticle = modelDao.findArticleById(id);
		System.out.println("result test FindArticleById : " +resultArticle.toString());
		assertEquals(id,resultArticle.getId());
	}
	
	@Test
	public void testFindArticleByCategory() {
//		String category = "Arbres";
//		ModelDao modelDao = new ModelDao();
//		ArticleDto resultArticle = modelDao.findArticleById(id);
//		System.out.println("result test FindArticleById : " +resultArticle.toString());
//		assertEquals(id,resultArticle.getId());
	}
	

}
