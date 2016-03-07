package com.floremipy.model.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.floremipy.model.article.dao.IModelArticleDao;
import com.floremipy.model.dto.ArticleDto;
import com.floremipy.model.dto.ArticleLightDto;

public class ModelServiceTest {

	@Test
	public void testfindAllArticlesDTO(){
		IModelArticleDao articleDao = Mockito.mock(IModelArticleDao.class);
		
		ArticleLightDto article = new ArticleLightDto();
		ArticleLightDto article2 = new ArticleLightDto();
		List<ArticleLightDto> liste = new ArrayList<ArticleLightDto>();
		liste.add(article);
		liste.add(article2);
		
		Mockito.when(articleDao.findAllArticlesLight()).thenReturn(liste);
		
		ModelService modelService = new ModelService();
		modelService.setArticleDao(articleDao);
		
		List<ArticleLightDto> list = modelService.findAllDto();
		
		Assert.assertEquals(2, list.size());		
	}
	
	@Test
	public void testfindArticleDTOByID_OK(){
		IModelArticleDao articleDao = Mockito.mock(IModelArticleDao.class);
		
		ArticleLightDto article = new ArticleLightDto();
		article.setId(4);
		
		Mockito.when(articleDao.findArticleLightById(4)).thenReturn(article);
		
		ModelService modelService = new ModelService();
		modelService.setArticleDao(articleDao);
		
		
		ArticleLightDto art = modelService.findArticleLightById(4);
		
		Assert.assertEquals(art, article);
		Assert.assertEquals(ArticleLightDto.class, art.getClass());
		
	}
	
	@Test
	public void testfindArticleDTOByID_NOK(){
		IModelArticleDao articleDao = Mockito.mock(IModelArticleDao.class);
		
		ArticleLightDto article2 = new ArticleLightDto();
		
		Mockito.when(articleDao.findArticleLightById(0)).thenReturn(null);

		
		ModelService modelService = new ModelService();
		modelService.setArticleDao(articleDao);
		
		ArticleLightDto art = modelService.findArticleLightById(0);
		
		Assert.assertEquals(null, modelService.findArticleLightById(0));
		Assert.assertEquals(null, modelService.findArticleLightById(2));
	}
	
	@Test
	public void testfindArticleDTOByCategorie_OK(){
		IModelArticleDao articleDao = Mockito.mock(IModelArticleDao.class);
		
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
		
		ModelService modelService = new ModelService();
		modelService.setArticleDao(articleDao);
		
		List<ArticleLightDto> art = modelService.findAllArticlesLightByCategory("arbuste");
		List<ArticleLightDto> art2 = modelService.findAllArticlesLightByCategory("mauvaise herbe");
		List<ArticleLightDto> art3 = modelService.findAllArticlesLightByCategory("palmier");

		
		
		Assert.assertEquals(liste, art);
		Assert.assertEquals(article3, art2.get(0));
		Assert.assertEquals(1,  art2.size());
		Assert.assertEquals(new ArrayList<ArticleLightDto>(), art3);

	}
	
	@Test
	public void testfindAllArticles(){
		IModelArticleDao articleDao = Mockito.mock(IModelArticleDao.class);
		
		ArticleDto article = new ArticleDto();
		ArticleDto article2 = new ArticleDto();
		List<ArticleDto> liste = new ArrayList<ArticleDto>();
		liste.add(article);
		liste.add(article2);
		
		Mockito.when(articleDao.findAllArticles()).thenReturn(liste);
		
		ModelService modelService = new ModelService();
		modelService.setArticleDao(articleDao);
		
		List<ArticleDto> list = modelService.findAll();
		
		Assert.assertEquals(2, list.size());		
	}
	
	@Test
	public void testfindArticleByID_OK(){
		IModelArticleDao articleDao = Mockito.mock(IModelArticleDao.class);
		
		ArticleDto article = new ArticleDto();
		article.setId(4);
		
		Mockito.when(articleDao.findArticleById(4)).thenReturn(article);
		
		ModelService modelService = new ModelService();
		modelService.setArticleDao(articleDao);
		
		
		ArticleDto art = modelService.findArticleById(4);
		
		Assert.assertEquals(art, article);
		Assert.assertEquals(ArticleDto.class, art.getClass());
		
	}
	
	

	

}
