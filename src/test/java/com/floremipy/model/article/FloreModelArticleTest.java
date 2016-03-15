package com.floremipy.model.article;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.floremipy.model.Version;
import com.floremipy.model.article.dao.ArticleDao;
import com.floremipy.model.article.dao.IArticleDao;
import com.floremipy.model.article.dto.ArticleDto;

public class FloreModelArticleTest {
	
	private final static String PERSISTENCE_UNIT_NAME = "FloreMipyWeb";
	public static EntityManagerFactory emf;
	public static EntityManager em;
	public static EntityTransaction transaction;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		int versionBaseUser = 7;
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em =  emf.createEntityManager();
		Version version = em.find(Version.class, 1);
		
		if (version.getVersion() != versionBaseUser) {
			System.out.println("");
			System.out.println("");
			System.out.println("********************************");
			System.out.println("**Version de la BDD floremipi incorrecte**");
			System.out.println("********************************");
			System.out.println("Veuillez l'importer depuis srv-dev/PARTAGES/FloreMipy-2016-02-29/FloreMipy/FloreMipiInit.sql");
			
			System.exit(1);
		}
		
	}
	
	@Test
	public void testFindAllArticles() {
		IArticleDao modelDao = new ArticleDao();
		List<ArticleDto> resultArticle = modelDao.findAllArticles();
		for(ArticleDto a : resultArticle){
			System.out.println("result test FindAllArticles : " +a);
		}	
		assertTrue(resultArticle.size() > 0);
		
	}
	
	@Test
	public void testFindArticleById() {
		int id = 1;
		IArticleDao modelDao = new ArticleDao();
		ArticleDto resultArticle = modelDao.findArticleById(id);
		System.out.println("result test FindArticleById : " +resultArticle.toString());
		assertEquals(id,resultArticle.getId());
	}
	
	@Test
	public void testFindAllArticlesByCategory() {
		String category = "Arbres";
		IArticleDao modelDao = new ArticleDao();
		List<ArticleDto> resultArticle = modelDao.findAllArticlesByCategory(category);
		System.out.println("result test FindAllArticlesByCategory(Arbres) : " +resultArticle.toString());
		assertTrue(resultArticle.size() > 0);
	}
	
	@Test
	public void testCreateArticle() {
		IArticleDao articleDao = new ArticleDao();
		int i = 0;
		String name = "";
		ArticleDto articleExists = null; 
		do {
			i++;
			name = "testCreateArticle" + i;
			articleExists = articleDao.findArticleByName(name);
		} while (articleExists != null);
		ArticleDto articleDto = new ArticleDto(
				0,"category", "description", "img/logo-naturemp.png", name, 1
				);
		
		ArticleDto newArticle = articleDao.createArticle(articleDto);
		System.out.println("result test testCreateArticle : " +newArticle.toString());
		assertTrue(newArticle.getId() != 0L);
	}
	
	@Test
	public void testDeleteArticle(){
		IArticleDao articleDao = new ArticleDao();
		int i = 0;
		String name = "";
		ArticleDto articleExists = null;
		do {
			i++;
			name = "testDeleteArticle" + i;
			articleExists = articleDao.findArticleByName(name);
		} while (articleExists != null);
		ArticleDto articleDto = new ArticleDto(
				0,"category", "description", "img/logo-naturemp.png", name, 1
		);
		
		ArticleDto newArticle = articleDao.createArticle(articleDto);
		int id = newArticle.getId();
		articleDao.deleteArticle(newArticle);
		assertTrue(articleDao.findArticleById(id) == null);
	}
	
	@Test
	public void testUpdateArticle() {
		LocalDateTime localDateTime = LocalDateTime.now();
		IArticleDao articleDao = new ArticleDao();
		int i = 0;
		String name = "testupdate " + localDateTime.toString();

		ArticleDto articleDto = new ArticleDto(
				0,"category", "description", "img/logo-naturemp.png", name, 1
		);
		ArticleDto newArticleDto = articleDao.createArticle(articleDto);
		name = name+"Update";
		newArticleDto.setName(name);
		articleDao.updateArticle(newArticleDto);
		
		ArticleDto verifyArticle = articleDao.findArticleByName(name);
		assertEquals(verifyArticle.getName(),name);
	}
	
	@Test
	public void testFindAllCategory() {
		IArticleDao modelDao = new ArticleDao();
		List<String> resultCategory = modelDao.findAllCategory();
		for (String s : resultCategory) {
			System.out.println("result test FindAllCategory : " +s);
		}
		assertTrue(resultCategory.size() > 0);
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception {
	em.close();
	emf.close();

	}
	

}

