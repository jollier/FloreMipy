package com.floremipy.model.article.web;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.floremipy.model.ShoppingCart;
import com.floremipy.model.article.service.IArticleService;
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

}
