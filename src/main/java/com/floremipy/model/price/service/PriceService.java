package com.floremipy.model.price.service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floremipy.model.article.dao.IArticleDao;
import com.floremipy.model.price.dao.IPriceDao;
import com.floremipy.model.price.dto.PriceDto;

@Service
public class PriceService implements IPriceService {
	
	@Autowired
	private IPriceDao Ipricedao;

	@Override
	public PriceDto createPriceForArticleId(PriceDto priceDto, int idArticle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal findPriceByArticleId(int id) {

		BigDecimal price = new BigDecimal(0);
		Date today = new Date();
		List<PriceDto> list = new ArrayList<PriceDto>();
		list = Ipricedao.findPriceByArticleId(id);
		
		for (PriceDto priceDto : list) {
			if  (priceDto.getDate().before(today)){
				price = priceDto.getValue();
				break;
			}
		}
		
		return price;
	}

	@Override
	public PriceDto findPriceById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePrice(PriceDto priceDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePrice(PriceDto priceDto) {
		// TODO Auto-generated method stub
		
	}
	
	public void setPriceDao(IPriceDao pricedao) {
		this.Ipricedao = pricedao;
	}
	
	

}
