package com.floremipy.model.article.web;

import java.math.BigDecimal;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.floremipy.model.article.dto.ArticleDto;
import com.floremipy.model.article.service.ArticleService;
import com.floremipy.model.article.service.IArticleService;
import com.floremipy.model.price.service.IPriceService;
//import com.floremipy.model.price.article.dto.ArticleLightDto;
 
@Controller
public class FicheArticleController {
 
	@Autowired
	IArticleService articleService;
	
	@Autowired
	IPriceService priceService;

	@RequestMapping(value = "/ficheArticle/{id}" , method = RequestMethod.GET)
   public String ficheArticle(Model model,@PathVariable("id") int id) {
	   
	   ArticleDto articleDto = new ArticleDto();
	   articleDto = articleService.findArticleById(id);
	   
	   BigDecimal price = priceService.findPriceByArticleId(id);
	   
	   //System.out.println(articleDto.getName());
       model.addAttribute("article", articleDto);
       model.addAttribute("price", price);
       return "ficheArticle";
   }
 
   @RequestMapping(value = "/ficheArticle/addkart/{id}{qte}", method = RequestMethod.GET)
   public String addKart(Model model,@PathVariable("id") int id,@PathVariable("qte") int qte) {

	   //TODO : Ajouter l'article au panier
	   
       return "addKart";
   }

}