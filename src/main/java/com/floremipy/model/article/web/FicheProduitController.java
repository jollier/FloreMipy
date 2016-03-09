package com.floremipy.model.article.web;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class FicheProduitController {
 
   @RequestMapping(value = { "/", "/FicheProduit" }, method = RequestMethod.GET)
   public String ficheProduit(Model model) {
       model.addAttribute("libelleArticle", "");
       model.addAttribute("qteStock", "");
       model.addAttribute("PUTTC", "");
       model.addAttribute("description", "");
       return "ficheProduit";
   }
 
   @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
   public String addKart(Model model) {
       model.addAttribute("title", "Logout");
       return "addKart";
   }

}