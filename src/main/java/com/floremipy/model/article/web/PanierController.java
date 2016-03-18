package com.floremipy.model.article.web;

import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.floremipy.model.ShoppingCart;
import com.floremipy.model.customer.service.ICustomerService;

@Controller
public class PanierController {
	
	@Autowired
	ICustomerService monService;
	
//	@Autowired
//	ShoppingCart shoppingCart;

	public static final HashMap<Integer, ShoppingCart> listArticlesPanier = new HashMap<Integer, ShoppingCart>();
	//public static final ArrayList<ShoppingCart> listArticlesPanier = new ArrayList<ShoppingCart>();
	
    public PanierController() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	@RequestMapping("/panier")
	
	public ModelAndView alimenterPanier(Model model){
		model.addAttribute("listArticlesPanier", listArticlesPanier);
		Double prixTotal = 0.00;

		for (Integer key : listArticlesPanier.keySet())
		{
			ShoppingCart art = listArticlesPanier.get(key);
			prixTotal = prixTotal + Double.parseDouble(art.getPrixTotal());
		}
		//NumberFormat format = new DecimalFormat("#0.00");
		
		model.addAttribute("prixTotal", String.format(Locale.ENGLISH,"%.2f",prixTotal));	
		
		return new ModelAndView("panier");
	}
	
	
	@RequestMapping(value="/supprimerArticle",  method = RequestMethod.POST)
	public ModelAndView supprimerArticle(Model model,HttpServletRequest request){
		
		Integer idArticle = Integer.valueOf(request.getParameter("idArticle"));
		System.out.println("mon ident est : " +idArticle);
		
		
		System.out.println("Avant Suppression : " + listArticlesPanier.size());
		listArticlesPanier.remove(idArticle );
		System.out.println("Après Suppression : " + listArticlesPanier.size());
		
		model.addAttribute("listArticlesPanier", listArticlesPanier);
		Double prixTotal = 0.00;

		for (Integer key : listArticlesPanier.keySet())
		{
			ShoppingCart art = listArticlesPanier.get(key);
			prixTotal = prixTotal + Double.parseDouble(art.getPrixTotal());
		}
		//NumberFormat format = new DecimalFormat("#0.00");
		
		model.addAttribute("prixTotal", String.format(Locale.ENGLISH,"%.2f",prixTotal));	
		
		HttpSession session = request.getSession();
		session.setAttribute("nbArticle", listArticlesPanier.size()); 
		
		return new ModelAndView("panier");
	}
	
}
