package com.floremipy.model.articleinprogress.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floremipy.model.articleinprogress.dao.IArticleInProgressDao;
import com.floremipy.model.articleinprogress.dto.ArticleInProgressDto;

@Service
public class ArticleInProgressService implements IArticleInProgressService {

	@Autowired
	IArticleInProgressDao articleInProgressDao;
	
	public void setArticleInProgressDao(IArticleInProgressDao articleInProgressDao) {
		this.articleInProgressDao = articleInProgressDao;
	}
	
	@Override
	public List<ArticleInProgressDto> findArticleInProgressByArticleId(int id) {
		
		return articleInProgressDao.findArticleInProgressByArticleId(id);
	}

	@Override
	public ArticleInProgressDto findArticleInProgressById(int id) {
		
		return articleInProgressDao.findArticleInProgressById(id);
	}

	@Override
	public ArticleInProgressDto createArticleInProgressForArticleId(ArticleInProgressDto articleInProgressDto,
			int idArticle) {
		
		return articleInProgressDao.createArticleInProgressForArticleId(articleInProgressDto, idArticle);
	}

	@Override
	public void updateArticleInProgress(ArticleInProgressDto articleInProgressDto) {
		articleInProgressDao.updateArticleInProgress(articleInProgressDto);

	}

	@Override
	public void deleteArticleInProgress(ArticleInProgressDto articleInProgressDto) {
		articleInProgressDao.deleteArticleInProgress(articleInProgressDto);

	}

}
