package com.floremipy.model.service;

import java.util.List;

import com.floremipy.model.article.dto.ArticleDto;
import com.floremipy.model.article.dto.ArticleLightDto;


public interface IModelService {

	boolean save(ArticleLightDto art);

	boolean delArticle(ArticleLightDto art);

	List<ArticleLightDto> findAllArticlesLightByCategory(String cat);

	ArticleLightDto findArticleLightById(int id);

	List<ArticleLightDto> findAllDto();
	
	List<ArticleDto> findAll();
	
	ArticleDto findArticleById(int id);

}
