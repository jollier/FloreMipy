
package com.floremipy.model.articleinprogress.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.floremipy.model.article.dto.ArticleDto;
import com.floremipy.model.article.service.ArticleService;
import com.floremipy.model.articleinprogress.dao.IArticleInProgressDao;
import com.floremipy.model.articleinprogress.dto.ArticleInProgressDto;

public class ArticleInProgressServiceTest {	
	
	@Test
	public void testfindArticleInProgressByArticleId(){
		
		IArticleInProgressDao articleDao = Mockito.mock(IArticleInProgressDao.class);
		
		ArticleInProgressDto articleip = new ArticleInProgressDto();
		articleip.setIdArticle(1);
		ArticleInProgressDto articleip2 = new ArticleInProgressDto();
		articleip2.setIdArticle(2);
		ArticleInProgressDto articleip3 = new ArticleInProgressDto();
		articleip3.setIdArticle(1);
		List<ArticleInProgressDto> list = new ArrayList<ArticleInProgressDto>();
		list.add(articleip);list.add(articleip3);
		List<ArticleInProgressDto> liste2 = new ArrayList<ArticleInProgressDto>();
		liste2.add(articleip2);

				
		Mockito.when(articleDao.findArticleInProgressByArticleId(1)).thenReturn(list);
		Mockito.when(articleDao.findArticleInProgressByArticleId(2)).thenReturn(liste2);
		Mockito.when(articleDao.findArticleInProgressByArticleId(0)).thenReturn(new ArrayList<ArticleInProgressDto>() );
		
		ArticleInProgressService modelService = new ArticleInProgressService();
		modelService.setArticleInProgressDao(articleDao);
		
		List<ArticleInProgressDto> result = modelService.findArticleInProgressByArticleId(1);
		Assert.assertEquals(2, result.size());		
		
		List<ArticleInProgressDto> result2 = modelService.findArticleInProgressByArticleId(2);
		Assert.assertEquals(1, result2.size());	
		
		List<ArticleInProgressDto> result3 = modelService.findArticleInProgressByArticleId(0);
		Assert.assertEquals(0, result3.size());	
	}

	@Test
	public void testfindArticleInProgressById(){
		//Arrange
		IArticleInProgressDao articleDao = Mockito.mock(IArticleInProgressDao.class);
		
		ArticleInProgressDto article = new ArticleInProgressDto();
		article.setId(4);
		
		Mockito.when(articleDao.findArticleInProgressById(4)).thenReturn(article);
		
		ArticleInProgressService modelService = new ArticleInProgressService();
		modelService.setArticleInProgressDao(articleDao);
		
		//Act
		ArticleInProgressDto art = modelService.findArticleInProgressById(4);
		
		//Assert
		Assert.assertEquals(art, article);
		Assert.assertEquals(ArticleInProgressDto.class, art.getClass());
		 
	}
	
	@Test
	public void testcreateArticleInProgressForArticleId(){
		
		//Arrange
			IArticleInProgressDao articleDao = Mockito.mock(IArticleInProgressDao.class);
			
			ArticleDto article = new ArticleDto();
			article.setId(1);
			
			ArticleInProgressDto articleinprogress = new ArticleInProgressDto();
			articleinprogress.setIdArticle(1);
			
			Mockito.when(articleDao.createArticleInProgressForArticleId(articleinprogress, 1)).thenReturn(articleinprogress);
			
			ArticleInProgressService modelService = new ArticleInProgressService();
			modelService.setArticleInProgressDao(articleDao);
			
			//Act
			ArticleInProgressDto art = modelService.createArticleInProgressForArticleId(articleinprogress, 1);
			
			//Assert
			Assert.assertEquals(art, articleinprogress);
			Assert.assertEquals(ArticleInProgressDto.class, art.getClass());
	}
	
}

