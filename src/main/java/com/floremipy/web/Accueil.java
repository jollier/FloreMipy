package com.floremipy.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.floremipy.model.article.dto.ArticleDto;
import com.floremipy.model.article.service.ArticleService;
import com.floremipy.model.article.service.IArticleService;


@Controller
public class Accueil {
	
	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String getdata(Model model) {

		IArticleService accueilService = new ArticleService();
		List<ArticleDto> artList = accueilService.findAll();

		model.addAttribute("artList", artList);

		return "accueil";
	}

}
