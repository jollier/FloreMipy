package com.floremipy.controller;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.floremipy.application.view.IFramePrincipal;
import com.floremipy.application.view.MainFrame;
import com.floremipy.product.model.ProductLight;
import com.floremipy.product.model.ProductListModel;
import com.floremipy.product.view.ProductListView;
import com.floremipy.product.webservice.IProductWebService;
import com.floremipy.product.webservice.ProductWebService;
import com.floremipy.view.IFormView;
import com.floremipy.view.IListView;
import com.floremipy.view.IView;

@Component
public class FloreMipyController  {

	// @Autowired
	// ProductListController myProductListController;

	@Autowired
	@Qualifier("productListView")
	IView productListView;
	// IListView productListView;


	@Autowired
	@Qualifier("Main")
	IFramePrincipal framePrincipal;

	// public FloreMipyController(FramePrincipal framePrincipal) {
	// super();
	// this.framePrincipal = framePrincipal;
	//
	// }

	public FloreMipyController() {
		super();
	}

	public void launch() {
		// test de la liste de produit
		// JComponent productListView = new ProductListView();
		// ((MainFrame)framePrincipal).initialize();
		
		
		productListView.openView(framePrincipal.getPanelCentral());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		
//	//	((IView)productListView).addView(framePrincipal, "productList", productListView);
//		
//		
//		framePrincipal.addView("productList", productListView);
//		
//		((IListView) productListView).addCreateActionListener(e -> {
//			framePrincipal.addView("productView", productView);
//			((IFormView) productView).addValidActionListener(e1 -> {
//				//System.out.println("Valide productView");
//				((IFormView) productView).removeAllActionListener();
//				framePrincipal.deleteView(productView);
//			});
//			((IFormView) productView).addCancelActionListener(e1 -> {
//				//System.out.println("Abandonne productView");
//				((IFormView) productView).removeAllActionListener();
//				framePrincipal.deleteView(productView);
//			});
//			framePrincipal.setActiveView("productView");
//			System.out.println("createButton");
//		});
//		
//		((IListView) productListView).addUpdateActionListener(e -> System.out.println("updateButton"));
//		((IListView) productListView).addDeleteActionListener(e -> System.out.println("deleteButton"));
//
//		// createButton.addActionListener(new ActionListener() {
//		// @Override
//		// public void actionPerformed(ActionEvent e) {
//		// System.out.println("createButton");
//		// }});
//
//		((IListView) productListView).loadData();
//		// ((ProductListView)productListView).loadData();
//
//
//
//		framePrincipal.setActiveView("productList");
//		// framePrincipal.setActiveView("productView");
		framePrincipal.view();
	}

	public IFramePrincipal getFramePrincipal() {
		return framePrincipal;

	}

	public void setFramePrincipal(IFramePrincipal framePrincipal) {
		this.framePrincipal = framePrincipal;
	}

//	public JComponent getProductListView() {
//		return productListView;
//	}
//
//	public void setProductListView(JComponent productListView) {
//		this.productListView = productListView;
//	}

//	@Override
//	public void onOpenView(String name, long id) {
//
//		productListView.open(framePrincipal.getPanelCentral(), 0L);
//		
//		((CardLayout)framePrincipal.getPanelCentral())
//	}
//
//	@Override
//	public void onViewClose() {
//		// TODO Auto-generated method stub
//		
//	}

}
