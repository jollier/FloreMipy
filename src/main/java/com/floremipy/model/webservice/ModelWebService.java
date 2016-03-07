package com.floremipy.model.webservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.floremipy.model.dto.ArticleLightDto;

@RestController
public class ModelWebService {


	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/article")
	public ArticleLightDto article(@RequestParam(value="id", defaultValue="0") int id, @RequestParam String category,
			@RequestParam String description, @RequestParam String name, @RequestParam(value="quantityInStock", defaultValue="0") int quantityInStock) {
		return new ArticleLightDto(  (int) counter.incrementAndGet(),category,description, name, quantityInStock);
		

	}
}