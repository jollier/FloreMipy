package com.floremipy.controller;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.floremipy.application.view.FramePrincipal;
import com.floremipy.application.view.MainFrame;
import com.floremipy.product.model.ProductLight;
import com.floremipy.product.model.ProductListModel;
import com.floremipy.product.view.IListView;
import com.floremipy.product.view.ProductListView;
import com.floremipy.product.webservice.IProductWebService;
import com.floremipy.product.webservice.ProductWebService;

@Component
public class FloreMipyController {

	//@Autowired
	//ProductListController myProductListController;
	
	@Autowired
	@Qualifier("productListView")
	JComponent productListView;
	//IListView productListView;
	
	@Autowired
	@Qualifier("Main")
	FramePrincipal framePrincipal;

//	public FloreMipyController(FramePrincipal framePrincipal) {
//		super();
//		this.framePrincipal = framePrincipal;
//		
//	}
	

	public FloreMipyController() {
		super();
	}


	public void launch() {
		// test de la liste de produit
		//JComponent productListView = new ProductListView();
		//((MainFrame)framePrincipal).initialize();
		framePrincipal.addView("productList",productListView);
		((IListView)productListView).loadData();
		//((ProductListView)productListView).loadData();
		framePrincipal.setActiveView("productList");
		framePrincipal.view();
	}


	public FramePrincipal getFramePrincipal() {
		return framePrincipal;
		
	}


	public void setFramePrincipal(FramePrincipal framePrincipal) {
		this.framePrincipal = framePrincipal;
	}


	public JComponent getProductListView() {
		return productListView;
	}


	public void setProductListView(JComponent productListView) {
		this.productListView = productListView;
	}

}

