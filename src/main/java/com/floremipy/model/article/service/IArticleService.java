package com.floremipy.model.article.service;

import java.util.List;

import com.floremipy.model.Article;
import com.floremipy.model.article.dto.ArticleDto;
import com.floremipy.model.article.dto.ArticleLightDto;


public interface IArticleService {

	List<ArticleLightDto> findAllArticlesLightByCategory(String cat);

	ArticleLightDto findArticleLightById(int id);

	List<ArticleLightDto> findAllDto();
	
	List<ArticleDto> findAll();
	
	ArticleDto findArticleById(int id);
	
	ArticleDto findArticleByName(String name);

	ArticleDto createArticle(ArticleDto newArticle);
	
	void deleteArticle(ArticleDto articleDto);
	
	void updateArticle(ArticleDto articleDto);


}
