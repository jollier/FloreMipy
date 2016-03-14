package com.floremipy.web;

import java.util.List;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.floremipy.model.article.dto.ArticleDto;
import com.floremipy.model.article.service.IArticleService;


@Controller
public class Accueil { 
	
	@Autowired
	IArticleService accueilService;
	
	@RequestMapping(value = {"/accueil", "/"}, method = RequestMethod.GET)
	public String getdata(@RequestParam(value="categorie", required=false) String categorie, Model model) {
	//public String getdata(Model model) {
		List<ArticleDto> artList = null;
		if (categorie != null) {
			//accueilService = new ArticleService();
			artList = accueilService.findAllArticlesByCategory(categorie);
			//List<ArticleDto> artList = accueilService.findAll();
		} else {
			artList = accueilService.findAll();
		}
		model.addAttribute("artList", artList);

		return "accueil";
	}

}
