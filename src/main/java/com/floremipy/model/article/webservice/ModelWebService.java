package com.floremipy.model.article.webservice;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.floremipy.model.article.dto.ArticleLightDto;



@RestController
public class ModelWebService {


	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/product")
	public ArticleLightDto article(@RequestParam(value="id", defaultValue="0") int id, @RequestParam String category,
			@RequestParam String description, @RequestParam String name, @RequestParam(value="quantityInStock", defaultValue="0") int quantityInStock,
			@RequestParam(value="value", defaultValue="0") BigDecimal value) {
		return new ArticleLightDto(  (int) counter.incrementAndGet(),category,description, name, quantityInStock, value);
		

	}
}