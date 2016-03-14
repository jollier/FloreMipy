package com.floremipy.model.price.service;

import java.math.BigDecimal;
import java.util.List;

import com.floremipy.model.price.dto.PriceDto;

public interface IPriceService {
	
	PriceDto createPriceForArticleId(PriceDto priceDto, int idArticle);

	BigDecimal findPriceByArticleId(int id);
	
	PriceDto findPriceById(int id);
	
	void updatePrice(PriceDto priceDto);
	
	void deletePrice(PriceDto priceDto);

}
