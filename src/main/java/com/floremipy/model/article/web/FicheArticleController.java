package com.floremipy.model.article.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.floremipy.model.article.dto.ArticleLightDto;
import com.floremipy.model.article.service.ArticleService;
import com.floremipy.model.article.service.IArticleService;
 
@Controller
public class FicheArticleController {
 
	@Autowired
	IArticleService articleService;
	
	@RequestMapping(value = "/ficheArticle/{id}" , method = RequestMethod.GET)
   public String ficheArticle(Model model,@PathVariable("id") int id) {
	   
	   ArticleLightDto articleLightDto = new ArticleLightDto();
	   articleLightDto = articleService.findArticleLightById(id);
//	   
       model.addAttribute("article", articleLightDto);
//       model.addAttribute("qteStock", articleLightDto.getQuantityInStock());
//       model.addAttribute("PUTTC", articleLightDto.getValue());
//       model.addAttribute("description", articleLightDto.getDescription());
       //model.addAttribute("image", articleLightDto.getDescription());
       return "ficheArticle";
   }
 
   @RequestMapping(value = "/ficheArticle/addkart/{id}{qte}", method = RequestMethod.GET)
   public String addKart(Model model,@PathVariable("id") int id,@PathVariable("qte") int qte) {

	   //TODO : Ajouter l'article au panier
	   
       return "addKart";
   }

}