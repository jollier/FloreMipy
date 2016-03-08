package com.floremipy.model.article.service;

import java.util.List;

import com.floremipy.model.Article;
import com.floremipy.model.article.dto.ArticleDto;
import com.floremipy.model.article.dto.ArticleLightDto;


public interface IModelService {

	void save(Article art);

	boolean delArticle(ArticleLightDto art);

	List<ArticleLightDto> findAllArticlesLightByCategory(String cat);

	ArticleLightDto findArticleLightById(int id);

	List<ArticleLightDto> findAllDto();
	
	List<ArticleDto> findAll();
	
	ArticleDto findArticleById(int id);
	
	ArticleDto createNewArticle(ArticleDto newArticle);


}
