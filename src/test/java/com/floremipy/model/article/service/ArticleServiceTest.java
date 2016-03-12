
package com.floremipy.model.article.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.floremipy.model.article.dao.IArticleDao;
import com.floremipy.model.article.dto.ArticleDto;

public class ArticleServiceTest {
/*
	@Test
	public void testFindAllDto(){
		//Arrange - preparation du mock
		IArticleDao articleDao = Mockito.mock(IArticleDao.class);
		
		ArticleLightDto article = new ArticleLightDto();
		ArticleLightDto article2 = new ArticleLightDto();
		List<ArticleLightDto> liste = new ArrayList<ArticleLightDto>();
		liste.add(article);
		liste.add(article2);
		
		Mockito.when(articleDao.findAllArticlesLight()).thenReturn(liste);
		
		ArticleService modelService = new ArticleService();
		modelService.setArticleDao(articleDao);
		
		//Act - appel de la methode a tester
		List<ArticleLightDto> list = modelService.findAllDto();
		
		//Assert - verification du test
		Assert.assertEquals(2, list.size());		
	}

	@Test
	public void testFindArticleLightByID_OK(){
		//Arrange
		IArticleDao articleDao = Mockito.mock(IArticleDao.class);
		
		ArticleLightDto article = new ArticleLightDto();
		article.setId(4);
		
		Mockito.when(articleDao.findArticleLightById(4)).thenReturn(article);
		
		ArticleService modelService = new ArticleService();
		modelService.setArticleDao(articleDao);
		
		//Act
		ArticleLightDto art = modelService.findArticleLightById(4);
		
		//Assert
		Assert.assertEquals(art, article);
		Assert.assertEquals(ArticleLightDto.class, art.getClass());
		 
	}
	
	@Test
	public void testFindArticleLightByID_NOK(){
		//Arrange
		IArticleDao articleDao = Mockito.mock(IArticleDao.class);
		
		ArticleLightDto article2 = new ArticleLightDto();
		
		Mockito.when(articleDao.findArticleLightById(0)).thenReturn(null);

		
		ArticleService modelService = new ArticleService();
		modelService.setArticleDao(articleDao);
		
		//Act
		ArticleLightDto art = modelService.findArticleLightById(0);
		
		//Assert
		Assert.assertEquals(null, modelService.findArticleLightById(0));
		Assert.assertEquals(null, modelService.findArticleLightById(2));
	}
	
	@Test
	public void testFindArticleLightByCategorie_OK(){
		//Arrange		
		IArticleDao articleDao = Mockito.mock(IArticleDao.class);
		
		ArticleLightDto article = new ArticleLightDto();
		article.setCategory("arbuste");
		ArticleLightDto article2 = new ArticleLightDto();
		article.setCategory("arbuste");
		ArticleLightDto article3 = new ArticleLightDto();
		article.setCategory("mauvaise herbe");
		
		List<ArticleLightDto> liste = new ArrayList<ArticleLightDto>();
		liste.add(article);
		liste.add(article2);
		
		List<ArticleLightDto> liste2 = new ArrayList<ArticleLightDto>();
		liste2.add(article3);

		
		Mockito.when(articleDao.findAllArticlesLightByCategory("arbuste")).thenReturn(liste);
		Mockito.when(articleDao.findAllArticlesLightByCategory("mauvaise herbe")).thenReturn(liste2);
		
		ArticleService modelService = new ArticleService();
		modelService.setArticleDao(articleDao);
		
		//act
		List<ArticleLightDto> art = modelService.findAllArticlesLightByCategory("arbuste");
		List<ArticleLightDto> art2 = modelService.findAllArticlesLightByCategory("mauvaise herbe");
		List<ArticleLightDto> art3 = modelService.findAllArticlesLightByCategory("palmier");

		//assert
		
		Assert.assertEquals(liste, art);
		Assert.assertEquals(article3, art2.get(0));
		Assert.assertEquals(1,  art2.size());
		Assert.assertEquals(new ArrayList<ArticleLightDto>(), art3);

	}

	@Test
	public void testfindAllArticlesDTO(){
		IArticleDao articleDao = Mockito.mock(IArticleDao.class);
		
		ArticleLightDto article = new ArticleLightDto();
		ArticleLightDto article2 = new ArticleLightDto();
		List<ArticleLightDto> liste = new ArrayList<ArticleLightDto>();
		liste.add(article);
		liste.add(article2);
		
		Mockito.when(articleDao.findAllArticlesLight()).thenReturn(liste);
		
		ArticleService modelService = new ArticleService();
		modelService.setArticleDao(articleDao);
		
		List<ArticleLightDto> list = modelService.findAllDto();
		
		Assert.assertEquals(2, list.size());		
	}
	
	@Test
	public void testfindArticleDTOByID_OK(){
		IArticleDao articleDao = Mockito.mock(IArticleDao.class);
		
		ArticleLightDto article = new ArticleLightDto();
		article.setId(4);
		
		Mockito.when(articleDao.findArticleLightById(4)).thenReturn(article);
		
		ArticleService modelService = new ArticleService();
		modelService.setArticleDao(articleDao);
		
		
		ArticleLightDto art = modelService.findArticleLightById(4);
		
		Assert.assertEquals(art, article);
		Assert.assertEquals(ArticleLightDto.class, art.getClass());
		
	}
	
	@Test
	public void testfindArticleDTOByID_NOK(){
		IArticleDao articleDao = Mockito.mock(IArticleDao.class);
		
		ArticleLightDto article2 = new ArticleLightDto();
		
		Mockito.when(articleDao.findArticleLightById(0)).thenReturn(null);

		
		ArticleService modelService = new ArticleService();
		modelService.setArticleDao(articleDao);
		
		ArticleLightDto art = modelService.findArticleLightById(0);
		
		Assert.assertEquals(null, modelService.findArticleLightById(0));
		Assert.assertEquals(null, modelService.findArticleLightById(2));
	}
	
	@Test
	public void testfindArticleDTOByCategorie_OK(){
		IArticleDao articleDao = Mockito.mock(IArticleDao.class);
		
		ArticleLightDto article = new ArticleLightDto();
		article.setCategory("arbuste");
		ArticleLightDto article2 = new ArticleLightDto();
		article.setCategory("arbuste");
		ArticleLightDto article3 = new ArticleLightDto();
		article.setCategory("mauvaise herbe");
		
		List<ArticleLightDto> liste = new ArrayList<ArticleLightDto>();
		liste.add(article);
		liste.add(article2);
		
		List<ArticleLightDto> liste2 = new ArrayList<ArticleLightDto>();
		liste2.add(article3);

		
		Mockito.when(articleDao.findAllArticlesLightByCategory("arbuste")).thenReturn(liste);
		Mockito.when(articleDao.findAllArticlesLightByCategory("mauvaise herbe")).thenReturn(liste2);
		
		ArticleService modelService = new ArticleService();
		modelService.setArticleDao(articleDao);
		
		List<ArticleLightDto> art = modelService.findAllArticlesLightByCategory("arbuste");
		List<ArticleLightDto> art2 = modelService.findAllArticlesLightByCategory("mauvaise herbe");
		List<ArticleLightDto> art3 = modelService.findAllArticlesLightByCategory("palmier");

		
		
		Assert.assertEquals(liste, art);
		Assert.assertEquals(article3, art2.get(0));
		Assert.assertEquals(1,  art2.size());
		Assert.assertEquals(new ArrayList<ArticleLightDto>(), art3);

	}*/

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

