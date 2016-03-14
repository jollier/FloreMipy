package com.floremipy.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.floremipy.product.controller.ProductListController;
import com.floremipy.product.model.ProductLight;
import com.floremipy.product.model.ProductListModel;
import com.floremipy.product.view.ProductListView;
import com.floremipy.product.webservice.IProductWebService;
import com.floremipy.product.webservice.ProductWebService;

@Component
public class FloreMipyController {

	@Autowired
	ProductListController myProductListController;

	public FloreMipyController(ProductListController myProductListController) {
		super();
		this.myProductListController = myProductListController;
		
	}
	

	public FloreMipyController() {
		super();
	}


	public void launch() {
		// test de la liste de produit
		myProductListController.launch();
	}


	public ProductListController getMyProductListController() {
		return myProductListController;
	}


	public void setMyProductListController(ProductListController myProductListController) {
		this.myProductListController = myProductListController;
	}
}
