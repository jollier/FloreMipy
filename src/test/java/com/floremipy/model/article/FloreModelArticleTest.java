package com.floremipy.model.article;

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

import com.floremipy.model.Adress;
import com.floremipy.model.Customer;
import com.floremipy.model.Version;
import com.floremipy.model.article.dao.IArticleDao;
import com.floremipy.model.article.dao.ArticleDao;
import com.floremipy.model.article.dto.ArticleDto;
import com.floremipy.model.article.dto.ArticleLightDto;
import com.floremipy.model.customer.dao.ModelCustomerDao;
import com.floremipy.user.dao.IUserDao;
import com.floremipy.user.dao.UserDao;
import com.floremipy.user.dto.UserDto;

public class FloreModelArticleTest {
	
	private final static String PERSISTENCE_UNIT_NAME = "FloreMipyWeb";
	public static EntityManagerFactory emf;
	public static EntityManager em;
	public static EntityTransaction transaction;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		int versionBaseUser = 5;
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
	public void testFindAllArticlesLightByCategory() {
		String category = "Arbres";
		IArticleDao modelDao = new ArticleDao();
		List<ArticleLightDto> resultArticle = modelDao.findAllArticlesLightByCategory(category);
		System.out.println("result test FindAllArticlesLightByCategory(Arbres) : " +resultArticle.toString());
		assertTrue(resultArticle.size() > 0);
	}
	
	@Test
	public void testFindAllArticlesLight() {

		IArticleDao modelDao = new ArticleDao();

		List<ArticleLightDto> resultArticle = modelDao.findAllArticlesLight();
		for(ArticleLightDto a : resultArticle){
			System.out.println("result test FindAllArticlesLight : " +a);
		}	
		assertTrue(resultArticle.size() > 0);
	}
	
	@Test
	public void testFindArticleLightById() {
		int id = 1;
		IArticleDao modelDao = new ArticleDao();
		ArticleLightDto resultArticle = modelDao.findArticleLightById(id);
		System.out.println("result test FindArticleLightById : " +resultArticle.toString());
		assertEquals(id,resultArticle.getId());
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

		ArticleDto articleDto = new ArticleDto(0,name, name, name, name,  1);

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
		ArticleDto articleDto = new ArticleDto(0,name, name, name, name,  1);
		ArticleDto newArticleDto = articleDao.createArticle(articleDto);
		
		int id = newArticleDto.getId();
		articleDao.deleteArticle(newArticleDto);
		assertTrue(articleDao.findArticleById(id) == null);
	}
	
	
	public void testUpdateArticle() {
		IArticleDao articleDao = new ArticleDao();
		int i = 0;
		String name = "";
		ArticleDto articleExists = null;
		do {
			i++;
			name = "testUpdateArticle" + i;
			articleExists = articleDao.findArticleByName(name);
		} while (articleExists != null);

		ArticleDto articleDto = new ArticleDto(0,name, name, name, name,  1);
		ArticleDto newArticleDto = articleDao.createArticle(articleDto);
		name = name+"Update";
		newArticleDto.setDescription(name);
		articleDao.updateArticle(newArticleDto);
		
		ArticleDto verifyArticle = articleDao.findArticleByName(name);
		assertEquals(verifyArticle.getDescription(),name);
		
		
	}
	
	
	

	@AfterClass
	public static void setUpAfterClass() throws Exception {
	em.close();
	emf.close();

	}
	

}
