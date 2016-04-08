package com.floremipy.model.article.webservice;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
			//System.out.println(articleDto.getId());
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
	
	@RequestMapping("/Product/getImageItem{id}")
	public byte[] getImageItem(@PathVariable String id) {
		int parsedId = Integer.parseInt(id);
		System.out.println(id);
		byte[] image = articleService.getImageByArticleId(parsedId);
		// encode en base64 pour regler pb de caracteres speciaux
		byte[] encodedbytes = Base64.encodeBase64(image);
		return encodedbytes;
	}
	
	@RequestMapping(value = "/Product/uploadImage", method = RequestMethod.POST)
	public ResponseEntity<String> updateImageItem(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
		ResponseEntity<String> response = null;
		System.out.println("updateImageItem: " + name);
		if (!file.isEmpty()) {
			try {
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("img/" + name)));
                FileCopyUtils.copy(file.getInputStream(), stream);
				stream.close();
				response = new ResponseEntity<String>(HttpStatus.OK);
			}
			catch (Exception e) {
				response = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
		}
		else {
			response = new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
		}
		return response;
		
	}
	
	
	@RequestMapping("/Product/item{id}")
	public ArticleDto article(@PathVariable String id) {
		int parsedId = Integer.parseInt(id);
		ArticleDto articleDto = articleService.findArticleById(parsedId);
	
		return articleDto;
	}
	
	@RequestMapping(value = "/Product/add", method = RequestMethod.POST)
	public ResponseEntity<ArticleDto> createArticle(@RequestBody ArticleDto product) {
		ResponseEntity<ArticleDto> response;
		if (product != null) {
			articleService.createArticle(product);
		  if (product.getImgsrc() == null) product.setImgsrc("");
		  response = new ResponseEntity<ArticleDto>(product, HttpStatus.OK);
		} else {
			response = new ResponseEntity<ArticleDto>(product, HttpStatus.NOT_ACCEPTABLE);
		}
		return response;
	}
	
	@RequestMapping(value = "/Product/update", method = RequestMethod.POST)
	public ResponseEntity<ArticleDto> updateArticle(@RequestBody ArticleDto product) {
		ResponseEntity<ArticleDto> response;
		if (product != null) {
		  articleService.updateArticle(product);
		  if (product.getImgsrc() == null) product.setImgsrc("");
		  response = new ResponseEntity<ArticleDto>(product, HttpStatus.OK);
		} else {
			response = new ResponseEntity<ArticleDto>(product, HttpStatus.NOT_ACCEPTABLE);
		}
		return response;
	}
	
	private boolean articleMature(int id){
		Date today = new Date();
		List<ArticleInProgressDto> result = articleInProgressService.findArticleInProgressByArticleId(id);
		boolean mature=false;
		for (ArticleInProgressDto article : result){
			
			mature = article.getReleaseDate().before(today)?true:false;
			//System.out.println("article id : "+id+" date maturité : "+article.getReleaseDate().toString()+" Maturite : "+mature+" today is :"+today);
			if (mature==true) {return mature;}
		}
		return mature;
		
	}
	
	@RequestMapping(value = "/Product/delete/{id}", method = RequestMethod.POST)
	public ResponseEntity deleteArticle(@PathVariable String id) {
		int parsedId = Integer.parseInt(id);
		ArticleDto articleDto = articleService.findArticleById(parsedId);

		ResponseEntity response;
		if (articleDto != null) {
			articleService.deleteArticle(articleDto);
			response = new ResponseEntity(HttpStatus.OK);
		} else {
			response = new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
		return response;
	}
}