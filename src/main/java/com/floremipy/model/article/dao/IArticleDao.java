package com.floremipy.model.article.dao;

import java.util.List;

import com.floremipy.model.Article;
import com.floremipy.model.article.dto.ArticleDto;
import com.floremipy.model.article.dto.ArticleLightDto;

public interface IArticleDao {

	List<ArticleDto> findAllArticles();

	ArticleDto findArticleById(int id);

	ArticleLightDto findArticleLightById(int id);

	List<ArticleLightDto> findAllArticlesLightByCategory(String category);

	List<ArticleLightDto> findAllArticlesLight();
	
	ArticleDto findArticleByName(String name);
	
	ArticleDto createNewArticle(ArticleDto newArticle);
	
	void ArticleDaoSave(Article article);

}