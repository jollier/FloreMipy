package com.floremipy.model.article.webservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.floremipy.model.article.dto.ArticleLightDto;
import com.floremipy.model.article.service.IArticleService;



@RestController
public class ModelWebService {

	@Autowired
	IArticleService articleService;
	private final AtomicLong counter = new AtomicLong();
	private List<ProductLight> list;

	@RequestMapping(value = "/Product/get")
	public ArticleLightDto article(@RequestParam(value="id", defaultValue="0") int id, @RequestParam String category,
			@RequestParam String description, @RequestParam String name, @RequestParam(value="quantityInStock", defaultValue="0") int quantityInStock,
			@RequestParam(value="value", defaultValue="0") BigDecimal value) {
		return new ArticleLightDto(id,category,description, name, quantityInStock, value);


	}

	@ResponseBody @RequestMapping(value = "/Product/list")
	public List<ProductLight> articlelist(@RequestParam(value="id", defaultValue="0") int id, @RequestParam(value="category", defaultValue="Arbre") String category,
			@RequestParam(value="description", defaultValue="Vert") String description, @RequestParam(value="name", defaultValue="ZouliNarbre") String name, @RequestParam(value="quantityInStock", defaultValue="0") int quantityInStock,
			@RequestParam(value="value", defaultValue="0") BigDecimal value) {



		List<ArticleLightDto> result = articleService.findAllDto();
		list = new ArrayList<ProductLight>();
		for (ArticleLightDto articleLightDto : result) {

			ProductLight pl = new ProductLight();
			pl.setId(articleLightDto.getId());
			pl.setName(articleLightDto.getName());
			pl.setCategory(articleLightDto.getCategory());
			pl.setQuantityInStock(articleLightDto.getQuantityInStock());
			pl.setAlertLotMature(0);
			list.add(pl);
		}




		/*String jsonInString = "";
		ObjectMapper mapper = new ObjectMapper();

		try {

			// Convert object to JSON string
			jsonInString = mapper.writeValueAsString(result);
			System.out.println(jsonInString);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/

		return list;


	}

}