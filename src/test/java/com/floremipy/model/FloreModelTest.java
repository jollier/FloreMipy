package com.floremipy.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.floremipy.model.article.dao.IModelArticleDao;
import com.floremipy.model.article.dao.ModelArticleDao;
import com.floremipy.model.dto.ArticleDto;
import com.floremipy.model.dto.ArticleLightDto;

public class FloreModelTest {
	
	private final static String PERSISTENCE_UNIT_NAME = "FloreMipyWeb";
	public static EntityManagerFactory emf;
	public static EntityManager em;
	public static EntityTransaction transaction;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em =  emf.createEntityManager();
		transaction =  em.getTransaction();
	}
	
	@Test
	public void testFindAllArticles() {
		IModelArticleDao modelDao = new ModelArticleDao();
		List<ArticleDto> resultArticle = modelDao.findAllArticles();
		for(ArticleDto a : resultArticle){
			System.out.println("result test FindAllArticles : " +a);
		}	
		assertTrue(resultArticle.size() > 0);
	}
	
	@Test
	public void testFindArticleById() {
		int id = 1;
		IModelArticleDao modelDao = new ModelArticleDao();
		ArticleDto resultArticle = modelDao.findArticleById(id);
		System.out.println("result test FindArticleById : " +resultArticle.toString());
		assertEquals(id,resultArticle.getId());
	}
	
	@Test
	public void testFindAllArticlesLightByCategory() {
		String category = "Arbres";
		IModelArticleDao modelDao = new ModelArticleDao();
		List<ArticleLightDto> resultArticle = modelDao.findAllArticlesLightByCategory(category);
		System.out.println("result test FindAllArticlesLightByCategory(Arbres) : " +resultArticle.toString());
		assertTrue(resultArticle.size() > 0);
	}
	
	public void testFindAllArticlesLight() {
		IModelArticleDao modelDao = new ModelArticleDao();
		List<ArticleLightDto> resultArticle = modelDao.findAllArticlesLigt();
		for(ArticleLightDto a : resultArticle){
			System.out.println("result test FindAllArticlesLight : " +a);
		}	
		assertTrue(resultArticle.size() > 0);
	}
	
	@Test
	public void testFindArticleLightById() {
		int id = 1;
		IModelArticleDao modelDao = new ModelArticleDao();
		ArticleLightDto resultArticle = modelDao.findArticleLightById(id);
		System.out.println("result test FindArticleLightById : " +resultArticle.toString());
		assertEquals(id,resultArticle.getId());
	}
	

	@AfterClass
	public static void setUpAfterClass() throws Exception {
	em.close();
	emf.close();

	}
	

}
