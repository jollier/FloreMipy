package com.floremipy.product.controller;

import java.util.Observable;
import java.util.Observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.floremipy.product.model.IProductListModel;
import com.floremipy.product.view.ProductListView;


@Component
public class ProductListController implements Observer {

	@Autowired
	IProductListModel productListModel;
	
	ProductListView productListView;

	public ProductListController(IProductListModel productListModel) {
		super();
		this.productListModel = productListModel;
	}

	public ProductListController() {
		super();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	public void launch() {
		productListView = new ProductListView(productListModel);

//		/* ajout du pattern observer de la view vers le controler */
//		productListView.addObserver(this);
//		
//		/* ajout du pattern observer du model vers la view */
//		((Observable) productListModel).addObserver(productListView);

		productListView.view();
		
	}
	
	
}
