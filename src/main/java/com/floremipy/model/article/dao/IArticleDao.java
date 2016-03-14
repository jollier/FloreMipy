package com.floremipy.model.article.dao;

/**
 * 
 */
import java.util.List;

import com.floremipy.model.article.dto.ArticleDto;

public interface IArticleDao {

	List<ArticleDto> findAllArticles();

	ArticleDto findArticleById(int id);

	List<ArticleDto> findAllArticlesByCategory(String category);
	
	ArticleDto findArticleByName(String name);
	
	ArticleDto createArticle(ArticleDto newArticle);
	
	void deleteArticle(ArticleDto articleDto);
	
	void updateArticle(ArticleDto articleDto);

}