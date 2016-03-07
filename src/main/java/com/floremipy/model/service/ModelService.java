package com.floremipy.model.service;

import java.util.List;

import com.floremipy.model.dto.ArticleLightDto;


public interface ModelService {

	boolean save(ArticleLightDto art);

	boolean delArticle(ArticleLightDto art);

	List<ArticleLightDto> findAllArticlesLightByCategory(String cat);

	ArticleLightDto getArticleById(int id);

	List<ArticleLightDto> getAll();
	
	

}
