package com.floremipy.model.customer.web;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ProfilController {
	
	@RequestMapping(value = "/profil", method = RequestMethod.GET)
	public String profilPage(Model model){
		
		
		return "profil";
		
	}
}
