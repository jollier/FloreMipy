package com.floremipy.controller;

import java.util.ArrayList;

import com.floremipy.product.model.ProductLight;
import com.floremipy.product.view.ProductList;

public class FloreMipyController {

	public FloreMipyController() {
		
		// test de la liste de produit
		
		
		// model
		ArrayList<ProductLight> listProduct = new ArrayList<ProductLight>();

		// view et Controller intégré à la view
		ProductList productList = new ProductList(listProduct);
		
		
		
		
	}
}
