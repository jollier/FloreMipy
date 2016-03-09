package com.floremipy.product.model;

import java.util.ArrayList;
import java.util.Observable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.floremipy.product.webservice.IProductWebService;

@Component
public class ProductListModel extends Observable implements IProductListModel{
	
	ArrayList<ProductLight> listProduct;
	
	@Autowired
	IProductWebService productWebService;
	
	public ProductListModel(IProductWebService productWebService) {
		super();
		this.productWebService = productWebService;
	}

	public ProductListModel() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.floremipy.product.model.IProductListModel#getListProduct()
	 */
	@Override
	public ArrayList<ProductLight> getListProduct() {
		listProduct = productWebService.getAllProductLight();
		return listProduct;
	}
	
	public void refresh() {
		setChanged();
		notifyObservers();
	}
}
