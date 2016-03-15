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

//	@RequestMapping(value = {"/ficheArticle/", "/ficheArticle"}, method = RequestMethod.GET)
//    public String ficheArticle(Model model,@RequestParam(value="id", required=false) int id) {

//	@RequestMapping(value = {"/ficheArticle/","/"}, method = RequestMethod.GET)
//	public String ficheArticle(@RequestParam(value="id", required=false) Integer id, Model model) {

	
   @RequestMapping(value = {"/ficheArticle/{id}"} , method = RequestMethod.GET)
   public String ficheArticle(Model model,@PathVariable("id") int id) {
	   
	   ArticleDto articleDto = new ArticleDto();
	   articleDto = articleService.findArticleById(id);
	   
	   BigDecimal price = priceService.findPriceByArticleId(id);
	   
	   //System.out.println(articleDto.getName());
       model.addAttribute("article", articleDto);
       model.addAttribute("price", price);
       return "ficheArticle";
   }
 

	@RequestMapping(value = {"/ficheArticle/{id}/ajouter"} , method = RequestMethod.GET)
	   public String addArticle(Model model, @PathVariable("id") int id, @RequestParam(value="qte",required=false) Integer qte) {
		//@RequestMapping(value = {"/panier/","/"}, method = RequestMethod.GET)
		// public String addKart(Model model,@RequestParam(value="id",required=false) Integer id,@RequestParam(value="qte",required=false) Integer qte) {
		
			   //TODO : Ajouter l'article au panier
		
			   ArticleDto articleDto = new ArticleDto();
			   articleDto = articleService.findArticleById(id);
			   
			   BigDecimal price = priceService.findPriceByArticleId(id);
		
			   System.out.println("passe addArticle : "+qte);
			   
		    return "redirect:/ficheArticle/"+id;
		}

}