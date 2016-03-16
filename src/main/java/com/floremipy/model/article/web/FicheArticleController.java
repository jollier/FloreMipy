package com.floremipy.model.article.web;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.floremipy.model.ShoppingCart;
import com.floremipy.model.article.dto.ArticleDto;
import com.floremipy.model.article.service.ArticleService;
import com.floremipy.model.article.service.IArticleService;
import com.floremipy.model.price.service.IPriceService;
//import com.floremipy.model.price.article.dto.ArticleLightDto;
 
@Controller
@Scope("session")
public class FicheArticleController {
 
	private String PANIER = "PANIER";
		
	@Autowired
	IArticleService articleService;
	
	@Autowired
	IPriceService priceService;

//	@Autowired
//	ShoppingCart shoppingCart;

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
	public String addArticle(Model model, @PathVariable("id") int id, @RequestParam(value="qte",required=false) Integer qte, HttpServletRequest request) {
		
			   //TODO : Ajouter l'article au panier
		
			   ArticleDto articleDto = new ArticleDto();
			   articleDto = articleService.findArticleById(id);
			   
			   System.out.println(qte);
			   BigDecimal price = priceService.findPriceByArticleId(id);

			   String qteString = (String) request.getAttribute("qte");
			   System.out.println(qteString);
			   if (qteString == null)
			   {
				   qteString="1";
			   }
			   ShoppingCart articleCart = new ShoppingCart(id, articleDto.getName(), price, Integer.parseInt(qteString));  
			   
			   
			   
	            HttpSession session = request.getSession();
	             
	            ArrayList<ShoppingCart> articlesPanier = (ArrayList<ShoppingCart>) session.getAttribute(PANIER);
	             //HashMap<Integer, ShoppingCart> articlesPanier = (HashMap<Integer, ShoppingCart>) session.getAttribute(PANIER); 
//	           
	            /* Si aucune map n'existe, alors initialisation d'une nouvelle map */
	             if ( articlesPanier == null ) {
	            	articlesPanier = PanierController.listArticlesPanier;
	             }
	            
//	             if (articlesPanier.containsKey(id))
//	             {
//	            	 ShoppingCart c = articlesPanier.get(id);
//	            	 c.setQteCommandee(c.getQteCommandee() + articleCart.getQteCommandee());
//	            	 articlesPanier.put(id, c);
//	             }
//	             else
//	             {
	  			   Double priceInDouble = price.doubleValue();
				   articleCart.setPrixTotal(articleCart.calculPrixTotal(priceInDouble, articleCart.getQteCommandee()));
//				   articlesPanier.put(id,articleCart);
//	             }
				   articlesPanier.add(articleCart);
				   
////	            /* Puis ajout de l'utilisateur dans la map */
////	            /* Et enfin (ré)enregistrement de la map en session */
//	            System.out.println(articlesPanier.size());
//
//	            session.setAttribute(PANIER, articlesPanier);
	           // System.out.println(articlesPanier.size() + "/" + qteString);
	            //			    
			   
		    return "redirect:/ficheArticle/"+id;
		}

}