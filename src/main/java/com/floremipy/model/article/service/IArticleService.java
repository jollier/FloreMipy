package com.floremipy.model.article.service;

import java.util.List;

import com.floremipy.model.article.dto.ArticleDto;


public interface IArticleService {

	List<ArticleDto> findAllArticlesByCategory(String cat);

	//ArticleLightDto findArticleLightById(int id);

	List<String> findAllCategories();
	
	List<ArticleDto> findAll();
	
	ArticleDto findArticleById(int id);
	
	ArticleDto findArticleByName(String name);

	ArticleDto createArticle(ArticleDto newArticle);
	
	void deleteArticle(ArticleDto articleDto);
	
	void updateArticle(ArticleDto articleDto);


}
