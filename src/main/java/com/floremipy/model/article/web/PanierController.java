package com.floremipy.model.article.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

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

	//public static final HashMap<String, PanierController> articlesPanierHashMap = new HashMap<String, PanierController>();
	public static final ArrayList<ShoppingCart> listArticlesPanier = new ArrayList<ShoppingCart>();
	
    public PanierController() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	@RequestMapping("/panier")
	
	public ModelAndView alimenterPanier(Model model){
		ShoppingCart c = new ShoppingCart(1, "Pommier", new BigDecimal(100.00),1);
		listArticlesPanier.add(c);
		model.addAttribute("listArticlesPanier", listArticlesPanier);
		
		return new ModelAndView("panier");
	}

}
