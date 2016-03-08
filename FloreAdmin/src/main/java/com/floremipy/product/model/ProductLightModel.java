package com.floremipy.product.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ProductLightModel extends AbstractTableModel {

	int PRODUCTLIGHTCOLUMNCOUNT = 4;
	ArrayList<ProductLight> listProduct;
	
	public ProductLightModel(ArrayList<ProductLight> listProduct) {
		super();
		this.listProduct = listProduct;
	}

	@Override
	public int getRowCount() {
		
		return listProduct.size();
	}

	@Override
	public int getColumnCount() {

		return PRODUCTLIGHTCOLUMNCOUNT;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ProductLight productLight = listProduct.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = productLight.getName();
                break;
            case 1:
                value = productLight.getCategory();
                break;
            case 2:
                value = productLight.getQuantityInStock();
                break;
            case 3:
                value = productLight.getAlertLotMature();
                break;
        }
        return value;
        
	}

}
