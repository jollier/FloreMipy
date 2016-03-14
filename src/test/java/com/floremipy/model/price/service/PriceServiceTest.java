
package com.floremipy.model.price.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.floremipy.model.articleinprogress.dao.IArticleInProgressDao;
import com.floremipy.model.articleinprogress.dto.ArticleInProgressDto;
import com.floremipy.model.articleinprogress.service.ArticleInProgressService;
import com.floremipy.model.price.dao.IPriceDao;
import com.floremipy.model.price.dto.PriceDto;

public class PriceServiceTest {	
	
	@Test
	public void testfindPriceByArticleId(){
		
		IPriceDao pricedao = Mockito.mock(IPriceDao.class);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = new Date();
		try {
			d = sdf.parse("01/07/2016");
		} catch (ParseException e) {
			e.printStackTrace();
		}
					
		PriceDto price = new PriceDto();
		price.setDate(d);
		price.setIdArticle(1);
		price.setValue(new BigDecimal(10));

		PriceDto price1 = new PriceDto();
		try {
			d = sdf.parse("01/03/2016");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		price1.setDate(d);
		price1.setIdArticle(1);
		price1.setValue(new BigDecimal(8));

		PriceDto price2 = new PriceDto();
		try {
			d = sdf.parse("01/01/2016");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		price2.setDate(d);
		price2.setIdArticle(1);
		price2.setValue(new BigDecimal(6));

		List<PriceDto> list = new ArrayList<PriceDto>();
		list.add(price);
		list.add(price1);
		list.add(price2);
	
		Mockito.when(pricedao.findPriceByArticleId(1)).thenReturn(list);
		
		PriceService modelService = new PriceService();
		modelService.setPriceDao(pricedao);
		
		BigDecimal result = modelService.findPriceByArticleId(1);
		Assert.assertEquals(new BigDecimal(8), result);		
		
	}

	@Test
	public void testCreatePriceforArticleId(){
		
		IPriceDao pricedao = Mockito.mock(IPriceDao.class);

		PriceDto price = new PriceDto();
		price.setIdArticle(1);
		price.setValue(new BigDecimal(10));
		
		Mockito.when(pricedao.createPriceForArticleId(price, 1)).thenReturn(price);
		
		PriceService modelService = new PriceService();
		modelService.setPriceDao(pricedao);
		
		PriceDto pdto = modelService.createPriceForArticleId(price, 1);
		
		Assert.assertEquals(price, pdto);	
		
	}
	
	@Test
	public void testFindPriceById(){
		//Arrange
		IPriceDao priceDao = Mockito.mock(IPriceDao.class);
		
		PriceDto price = new PriceDto();
		price.setId(4);
		
		Mockito.when(priceDao.findPriceById(4)).thenReturn(price);
		
		PriceService modelService = new PriceService();
		modelService.setPriceDao(priceDao);
		
		//Act
		PriceDto p = modelService.findPriceById(4);
		
		//Assert
		Assert.assertEquals(p, price);
		Assert.assertEquals(PriceDto.class, p.getClass());
		 
	}
	
}

