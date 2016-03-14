package com.floremipy.model.price.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floremipy.model.price.dao.IPriceDao;
import com.floremipy.model.price.dto.PriceDto;

@Service
public class PriceService implements IPriceService {
	
	@Autowired
	private IPriceDao Ipricedao;

	@Override
	public PriceDto createPriceForArticleId(PriceDto priceDto, int idArticle) {
		return Ipricedao.createPriceForArticleId(priceDto, idArticle);
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
		return Ipricedao.findPriceById(id);
	}

	@Override
	public void updatePrice(PriceDto priceDto) {
		Ipricedao.updatePrice(priceDto);
	}

	@Override
	public void deletePrice(PriceDto priceDto) {
		Ipricedao.deletePrice(priceDto);
	}
	
	public void setPriceDao(IPriceDao pricedao) {
		this.Ipricedao = pricedao;
	}
	
	

}
