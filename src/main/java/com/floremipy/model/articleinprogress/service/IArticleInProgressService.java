package com.floremipy.model.articleinprogress.service;

import java.util.List;

import com.floremipy.model.articleinprogress.dto.ArticleInProgressDto;

public interface IArticleInProgressService {

	
	List<ArticleInProgressDto> findArticleInProgressByArticleId(int id);
	
	ArticleInProgressDto findArticleInProgressById(int id);
	
	ArticleInProgressDto createArticleInProgressForArticleId(ArticleInProgressDto articleInProgressDto, int idArticle);
	
	void updateArticleInProgress(ArticleInProgressDto articleInProgressDto);
	
	void deleteArticleInProgress(ArticleInProgressDto articleInProgressDto);
}
