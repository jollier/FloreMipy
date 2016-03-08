package com.floremipy.product.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import com.floremipy.product.model.ProductLight;
import com.floremipy.product.model.ProductLightModel;

public class ProductList {

	ArrayList<ProductLight> listProduct;
	
	public ProductList(ArrayList<ProductLight> listProduct) {
		super();
		this.listProduct = listProduct;
		initialize();
	}
	
	JFrame productListFrame = null;
	JPanel productListPanel = null;
	JTable productList = null;
    JButton createButton = null;
    JButton updateButton = null;
    JButton deleteButton = null;
	
	
	void initialize() {
		
		
		createButton = new JButton("Create");
		
        updateButton = new JButton("Update");
        updateButton.setEnabled(false);
        
        deleteButton = new JButton("Delete");
        deleteButton.setEnabled(false);
        
        productList = new JTable();
        ProductLightModel model = new ProductLightModel(listProduct);
        productList.setModel(model);
        
//		productListPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		productListPanel = new JPanel(new BorderLayout());
		productListPanel.setPreferredSize(new Dimension(400, 400));
		productListPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 10));
        
		productListPanel.add(productList);
		productListPanel.add(createButton);
		productListPanel.add(updateButton);
		productListPanel.add(deleteButton);
		productListPanel.setLayout(new BoxLayout(productListPanel, BoxLayout.LINE_AXIS));

		//productListFrame.setLayout(new FlowLayout(FlowLayout.LEFT));

		productListFrame = new JFrame();
		productListFrame.add(productListPanel);

		
		// Jeu de données Test
		ProductLight p = new ProductLight(1L, "Sapin", "Conifère", 5, 1);
		listProduct.add(p);
		
		productListFrame.show();

	}
}
