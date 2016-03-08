package com.floremipy.model.article.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.floremipy.model.Article;
import com.floremipy.model.article.dao.IArticleDao;
import com.floremipy.model.article.dto.ArticleDto;
import com.floremipy.model.article.dto.ArticleLightDto;

public class ModelService implements IModelService {
	
	@Autowired
	IArticleDao articleDao;

	@Override
	public List<ArticleLightDto> findAllDto() {
		
		return articleDao.findAllArticlesLight();
	}

	
	@Override
	public ArticleLightDto findArticleLightById(int id) {

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
	public void save(Article art) {
		articleDao.ArticleDaoSave(art);
	}


	public void setArticleDao(IArticleDao articleDao) {
		this.articleDao = articleDao;
	}


	public ArticleDto findArticleById(int id) {
		
		return articleDao.findArticleById(id);
	}

	@Override
	public List<ArticleDto> findAll() {
		return articleDao.findAllArticles();
	}


	@Override
	public ArticleDto createNewArticle(ArticleDto newArticle) {
		return articleDao.createNewArticle(newArticle);
	}


	

}
