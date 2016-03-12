package com.floremipy.model.article.webservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.floremipy.model.article.dto.ArticleDto;
import com.floremipy.model.article.service.IArticleService;



@RestController
public class ModelWebService {

	@Autowired
	IArticleService articleService;
	//private final AtomicLong counter = new AtomicLong();
	private List<ProductLight> list;

	@RequestMapping(value = "/Product")
	public ArticleDto article(@RequestParam(value="id", defaultValue="0") int id, @RequestParam String category,
			@RequestParam String description, @RequestParam String imgsrc, @RequestParam String name, @RequestParam(value="quantityInStock", defaultValue="0") int quantityInStock) 
	{
		return new ArticleDto(id,category,description,imgsrc, name, quantityInStock);
	}

	@ResponseBody @RequestMapping(value = "/Product/list")
	public List<ProductLight> articlelist() {

		List<ArticleDto> result = articleService.findAll();
		list = new ArrayList<ProductLight>();
		for (ArticleDto articleDto : result) {

			ProductLight pl = new ProductLight();
			pl.setId(articleDto.getId());
			pl.setName(articleDto.getName());
			pl.setCategory(articleDto.getCategory());
			pl.setQuantityInStock(articleDto.getQuantityInStock());
			pl.setAlertLotMature(0);
			list.add(pl);
		}

		return list;
	}
}