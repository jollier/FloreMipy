package com.floremipy.model.price.dao;

import java.util.List;

import com.floremipy.model.price.dto.PriceDto;

public interface IPriceDao {

	void createPriceForArticleId(PriceDto priceDto, int idArticle);

	List<PriceDto> findPriceByArticleId(int id);
	PriceDto findPriceById(int id);
	
	void updatePrice(PriceDto priceDto);
	
	void deletePrice(PriceDto priceDto);

}