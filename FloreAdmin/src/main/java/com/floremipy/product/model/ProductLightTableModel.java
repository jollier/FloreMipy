package com.floremipy.product.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ProductLightTableModel extends AbstractTableModel {

	int PRODUCTLIGHTCOLUMNCOUNT = 5;
	final public String[] names = {"Nom", "Catégorie", "Stock", "Alert Lot mature", "Id"};
	
	ArrayList<ProductLight> listProduct;
	
	public ProductLightTableModel(ArrayList<ProductLight> listProduct) {
		super();
		System.out.println("ProductLightTableModel");
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
            case 4:
                value = productLight.getId();
                break;        }
        return value;
        
	}

	public String getColumnName(int column) {return names[column];}
	public Class getColumnClass(int col) {return getValueAt(0,col) .getClass() ;}
}
