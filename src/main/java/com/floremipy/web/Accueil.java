package com.floremipy.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.floremipy.model.article.dto.ArticleDto;
import com.floremipy.model.article.service.IArticleService;


@Controller
public class Accueil { 
	
	@Autowired
	IArticleService accueilService;
	
	@RequestMapping(value = {"/accueil", "/"}, method = RequestMethod.GET)
	public String getdata(@RequestParam(value="categorie", defaultValue="Toutes", required=false) String categorie, Model model) {
		List<ArticleDto> artList = null;

		if(!categorie.equals("Toutes")) {
			artList = accueilService.findAllArticlesByCategory(categorie);
		} else {
			artList = accueilService.findAll();
		}
		model.addAttribute("artList", artList);
		
		List<String> catList = accueilService.findAllCategories();
		model.addAttribute("catList", catList);

		return "accueil";
	}

	@RequestMapping("/cGVentes")
	public ModelAndView cGVentes() {
	
		return new ModelAndView ("cGVentes");
	}
	
	@RequestMapping("/cGEnvoi")
	public ModelAndView cGEnvoi() {
	
		return new ModelAndView ("cGEnvoi");
	}
	

		
	@RequestMapping("/quiSommesNous")
		
	public ModelAndView test(){
		return new ModelAndView("quiSommesNous");
	}

}
