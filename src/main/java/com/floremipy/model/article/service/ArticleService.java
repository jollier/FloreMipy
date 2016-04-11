package com.floremipy.model.article.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.ws.WebServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floremipy.model.article.dao.IArticleDao;
import com.floremipy.model.article.dto.ArticleDto;
//import com.floremipy.model.price.article.dto.ArticleLightDto;

@Service
public class ArticleService implements IArticleService {
	
    private String imagesPath = "img/";
	
	@Autowired
	IArticleDao articleDao;

	@Override
	public List<ArticleDto> findAllArticlesByCategory(String cat){
		return articleDao.findAllArticlesByCategory(cat);
	}

	@Override
	public void updateArticle(ArticleDto articleDto) {
		articleDao.updateArticle(articleDto);
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
	public ArticleDto createArticle(ArticleDto newArticle) {
		return articleDao.createArticle(newArticle);
	}


	@Override
	public ArticleDto findArticleByName(String name) {
		return articleDao.findArticleByName(name);
	} 


	@Override
	public void deleteArticle(ArticleDto articleDto) {
		articleDao.deleteArticle(articleDto);
	}

	@Override
	public List<String> findAllCategories() {
		return articleDao.findAllCategory();
	}
	
	@Override
	public byte[] getImageByArticleId(int id) {
		
		ArticleDto articleDto = articleDao.findArticleById(id);
		String imageFileName = articleDto.getImgsrc();
		try {
            File file = new File(imagesPath + imageFileName);
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream inputStream = new BufferedInputStream(fis);
            byte[] fileBytes = new byte[(int) file.length()];
            inputStream.read(fileBytes);
            inputStream.close();
             
            return fileBytes;
        } catch (IOException ex) {
            System.err.println(ex);
            return null;
        }      
	}
}

