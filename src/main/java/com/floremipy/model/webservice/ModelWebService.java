package com.floremipy.model.webservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.floremipy.model.dto.ArticleLightDto;

@RestController
public class ModelWebService {


	//private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/article")
	public ArticleLightDto article(int id, String category, String description, String name, int quantityInStock) {
		return new ArticleLightDto( id, category, description, name, quantityInStock);

	}
}