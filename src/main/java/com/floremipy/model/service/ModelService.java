package com.floremipy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.floremipy.model.article.dao.IModelArticleDao;
import com.floremipy.model.dto.ArticleLightDto;

public class ModelService implements IModelService {
	
	@Autowired
	IModelArticleDao articleDao;

	@Override
	public List<ArticleLightDto> getAll() {
		
		return articleDao.findAllArticlesLight();
	}

	
	@Override
	public ArticleLightDto getArticleById(int id) {

		return articleDao.findArticleLightById(id);
	}
	
	
	@Override
	public List<ArticleLightDto> findAllArticlesLightByCategory(String cat){
		return articleDao.findAllArticlesLightByCategory(cat);
	}

	
	@Override
	public boolean delArticle(ArticleLightDto art) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public boolean save(ArticleLightDto art) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
