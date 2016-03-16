package com.floremipy.model.article.webservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.floremipy.model.article.dto.ArticleDto;
import com.floremipy.model.article.service.IArticleService;
import com.floremipy.model.articleinprogress.dto.ArticleInProgressDto;
import com.floremipy.model.articleinprogress.service.IArticleInProgressService;



@RestController
public class ModelWebService {

	@Autowired
	IArticleService articleService;
	@Autowired
	IArticleInProgressService articleInProgressService;
	//private final AtomicLong counter = new AtomicLong();
	private List<ProductLight> list;

	@RequestMapping(value = "/Product")
	public ArticleDto article(@RequestParam(value="id", defaultValue="0") int id, String category,
			String description, String imgsrc, String name, int quantityInStock)
//	public ArticleDto article(@RequestParam(value="id", defaultValue="0") int id)
	{
//		return new ArticleDto(id,category,description,imgsrc, name, quantityInStock);
		return new ArticleDto(id,category,description,imgsrc, name, quantityInStock);
	}

	@ResponseBody @RequestMapping(value = "/Product/list")
	public List<ProductLight> articlelist() {
		
		List<ArticleDto> result = articleService.findAll();
		list = new ArrayList<ProductLight>();
		for (ArticleDto articleDto : result) {

			ProductLight pl = new ProductLight();
			pl.setId(articleDto.getId());
			System.out.println(articleDto.getId());
			pl.setName(articleDto.getName());
			pl.setCategory(articleDto.getCategory());
			pl.setQuantityInStock(articleDto.getQuantityInStock());
			
			boolean lotMature = articleMature(articleDto.getId());
			if (lotMature) {
				pl.setAlertLotMature(1);
			}else{
				pl.setAlertLotMature(0);
			}
				
			list.add(pl);
		}

		return list;
	}
	
	
	@RequestMapping("/Product/item{id}")
	public ProductLight article(@PathVariable String id) {
		int parsedId = Integer.parseInt(id);
		ProductLight item= new ProductLight();
		ArticleDto articleDto = articleService.findArticleById(parsedId);
		
			item.setId(articleDto.getId());
			System.out.println(articleDto.getId());
			item.setName(articleDto.getName());
			item.setCategory(articleDto.getCategory());
			item.setQuantityInStock(articleDto.getQuantityInStock());
			
			boolean lotMature = articleMature(articleDto.getId());
			if (lotMature) {
				item.setAlertLotMature(1);
			}else{
				item.setAlertLotMature(0);
			}
		return item;
	}
	
	private boolean articleMature(int id){
		Date today = new Date();
		List<ArticleInProgressDto> result = articleInProgressService.findArticleInProgressByArticleId(id);
		boolean mature=false;
		for (ArticleInProgressDto article : result){
			
			mature = article.getReleaseDate().before(today)?true:false;
			System.out.println("article id : "+id+" date maturité : "+article.getReleaseDate().toString()+" Maturite : "+mature+" today is :"+today);
			if (mature==true) {return mature;}
		}
		return mature;
		
	}
}