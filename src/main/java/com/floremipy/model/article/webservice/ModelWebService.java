package com.floremipy.model.article.webservice;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.floremipy.model.article.dto.ArticleLightDto;
import com.floremipy.model.article.service.IArticleService;



@RestController
public class ModelWebService {

	@Autowired
	IArticleService articleService;
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/product/get")
	public ArticleLightDto article(@RequestParam(value="id", defaultValue="0") int id, @RequestParam String category,
			@RequestParam String description, @RequestParam String name, @RequestParam(value="quantityInStock", defaultValue="0") int quantityInStock,
			@RequestParam(value="value", defaultValue="0") BigDecimal value) {
		return new ArticleLightDto(id,category,description, name, quantityInStock, value);
		

	}
	
	@ResponseBody @RequestMapping(value = "/productlist")
	public List<ArticleLightDto> articlelist(@RequestParam(value="id", defaultValue="0") int id, @RequestParam(value="category", defaultValue="Arbre") String category,
			@RequestParam(value="description", defaultValue="Vert") String description, @RequestParam(value="name", defaultValue="ZouliNarbre") String name, @RequestParam(value="quantityInStock", defaultValue="0") int quantityInStock,
			@RequestParam(value="value", defaultValue="0") BigDecimal value) {
	
		
		
		List<ArticleLightDto> result = articleService.findAllDto();
		String jsonInString = "";
		ObjectMapper mapper = new ObjectMapper();

		try {
			
			// Convert object to JSON string
			jsonInString = mapper.writeValueAsString(result+" AlerteArticle {Test rajout info supp}");
			System.out.println(jsonInString);
	
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return result;
		

	}
}