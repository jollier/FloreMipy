
package com.floremipy.model.article.service;

import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.floremipy.model.article.dao.IArticleDao;
import com.floremipy.model.article.dto.ArticleDto;

public class ArticleServiceTest {
	
	@Test
	public void testfindAllCategories(){
		IArticleDao articleDao = Mockito.mock(IArticleDao.class);
		
		ArticleDto article = new ArticleDto();
		article.setCategory("Arbre");
		ArticleDto article1 = new ArticleDto();
		article1.setCategory("Arbuste");
		ArticleDto article2 = new ArticleDto();
		article2.setCategory("Arbre");
		ArticleDto article3 = new ArticleDto();	
		article3.setCategory(null);
		List<String> list = new ArrayList<String>();
		list.add(article.getCategory()); list.add(article1.getCategory());
		//list.add(article2.getCategory());list.add(article3.getCategory());
		
		Mockito.when(articleDao.findAllCategory()).thenReturn(list);

		
		ArticleService modelService = new ArticleService();
		modelService.setArticleDao(articleDao);
		
		List<String> categories = modelService.findAllCategories();
		
		Assert.assertEquals(2, categories.size());
	}
	
	
	@Test
	public void testfindArticleDTOByCategorie_OK(){
		IArticleDao articleDao = Mockito.mock(IArticleDao.class);
		
		ArticleDto article = new ArticleDto();
		article.setCategory("arbuste");
		ArticleDto article2 = new ArticleDto();
		article.setCategory("arbuste");
		ArticleDto article3 = new ArticleDto();
		article.setCategory("mauvaise herbe");
		
		List<ArticleDto> liste = new ArrayList<ArticleDto>();
		liste.add(article);
		liste.add(article2);
		
		List<ArticleDto> liste2 = new ArrayList<ArticleDto>();
		liste2.add(article3);

		
		Mockito.when(articleDao.findAllArticlesByCategory("arbuste")).thenReturn(liste);
		Mockito.when(articleDao.findAllArticlesByCategory("mauvaise herbe")).thenReturn(liste2);
		
		ArticleService modelService = new ArticleService();
		modelService.setArticleDao(articleDao);
		
		List<ArticleDto> art = modelService.findAllArticlesByCategory("arbuste");
		List<ArticleDto> art2 = modelService.findAllArticlesByCategory("mauvaise herbe");
		List<ArticleDto> art3 = modelService.findAllArticlesByCategory("palmier");

		
		
		Assert.assertEquals(liste, art);
		Assert.assertEquals(article3, art2.get(0));
		Assert.assertEquals(1,  art2.size());
		Assert.assertEquals(new ArrayList<ArticleDto>(), art3);

	}

	@Test
	public void testFindAll(){
		//Arrange
		IArticleDao articleDao = Mockito.mock(IArticleDao.class);
		
		ArticleDto article = new ArticleDto();
		ArticleDto article2 = new ArticleDto();
		List<ArticleDto> liste = new ArrayList<ArticleDto>();
		liste.add(article);
		liste.add(article2);
		
		Mockito.when(articleDao.findAllArticles()).thenReturn(liste);
		
		ArticleService modelService = new ArticleService();
		modelService.setArticleDao(articleDao);
		
		//act
		List<ArticleDto> list = modelService.findAll();
		
		//assert
		Assert.assertEquals(2, list.size());		
	}

	
	@Test
	public void testfindArticleByID_OK(){
		//Arrange
		IArticleDao articleDao = Mockito.mock(IArticleDao.class);
		
		ArticleDto article = new ArticleDto();
		article.setId(4);
		
		Mockito.when(articleDao.findArticleById(4)).thenReturn(article);
		
		ArticleService modelService = new ArticleService();
		modelService.setArticleDao(articleDao);
		
		//Act
		ArticleDto art = modelService.findArticleById(4);
		
		//Assert
		Assert.assertEquals(art, article);
		Assert.assertEquals(ArticleDto.class, art.getClass());
		
	}
	
	
	@Test
	public void testCreateNewArticle(){
		
		//Arrange
		IArticleDao articleDao = Mockito.mock(IArticleDao.class);
		
		ArticleDto a = new ArticleDto();
		Mockito.when(articleDao.createArticle(a)).thenReturn(a);
		
		ArticleService modelService = new ArticleService();
		modelService.setArticleDao(articleDao);
		
		//Act
		ArticleDto art = modelService.createArticle(a);
		
		//Assert
		Assert.assertEquals(a, art);
		Assert.assertEquals(ArticleDto.class, a.getClass());
	}
	
	//pas besoin de commentaire
	@Test
	public void testHommage(){
		Assert.assertNotEquals(4, 3+2);
	}
	
	@Test
	public void testfindArticleByName_OK(){
		//Arrange
		IArticleDao articleDao = Mockito.mock(IArticleDao.class);
		
		ArticleDto article = new ArticleDto();
		String name="article_name";
		article.setName(name);
		
		Mockito.when(articleDao.findArticleByName(name)).thenReturn(article);
		
		ArticleService modelService = new ArticleService();
		modelService.setArticleDao(articleDao);
		
		//Act
		ArticleDto art = modelService.findArticleByName(name);
		
		//Assert
		Assert.assertEquals(art, article);
		
	}
	


}

