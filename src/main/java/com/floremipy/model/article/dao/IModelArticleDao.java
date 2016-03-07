package com.floremipy.model.article.dao;

import java.util.List;

import com.floremipy.model.dto.ArticleDto;
import com.floremipy.model.dto.ArticleLightDto;

public interface IModelArticleDao {

	List<ArticleDto> findAllArticles();

	ArticleDto findArticleById(int id);

	ArticleLightDto findArticleLightById(int id);

	List<ArticleLightDto> findAllArticlesLightByCategory(String category);

	List<ArticleLightDto> findAllArticlesLigt();

}