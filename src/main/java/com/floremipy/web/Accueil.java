package com.floremipy.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.floremipy.model.Article;
import com.floremipy.service.AccueilService;


@Controller
public class Accueil {
	
	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String getdata(Model model) {

		AccueilService accueilService = new AccueilService();
		List<ArticleDto> artList = accueilService.findAll();

		model.addAttribute("artList", artList);

		return "accueil";
	}

}
