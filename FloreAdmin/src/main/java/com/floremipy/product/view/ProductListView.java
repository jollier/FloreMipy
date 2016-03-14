package com.floremipy.product.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.springframework.beans.factory.annotation.Autowired;


import com.floremipy.product.model.IProductListModel;
import com.floremipy.product.model.ProductLight;
import com.floremipy.product.model.ProductLightTableModel;
import com.google.gson.JsonSyntaxException;

//@org.springframework.stereotype.Component
public class ProductListView extends Observable implements Observer {

	IProductListModel productListModel;
	ArrayList<ProductLight> listProduct;

	boolean ready = false;

	public ProductListView(IProductListModel productListModel) {
		super();
		this.productListModel = productListModel;
		// this.listProduct = listProduct;
		// initialize();
	}

	JFrame productListFrame = null;
	JPanel productListPanel = null;
	JScrollPane scrollpane = null;
	JTable productList = null;
	JButton createButton = null;
	JButton updateButton = null;
	JButton deleteButton = null;

	public void view() {
		initialize();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*
					 * Lance le thread de la fenetre et la lecture des touches
					 * du clavier
					 */

					ready = true;
					productListFrame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	void initialize() {

		productListFrame = new JFrame();

		createButton = new JButton("Create");
		// createButton.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// System.out.println("createButton");
		// }});
		createButton.addActionListener(e -> System.out.println("createButton"));

		updateButton = new JButton("Update");
		updateButton.setEnabled(false);
		updateButton.addActionListener(e -> System.out.println("updateButton"));

		deleteButton = new JButton("Delete");
		deleteButton.setEnabled(false);
		deleteButton.addActionListener(e -> System.out.println("deleteButton"));

		productList = new JTable();
		ProductLightTableModel model = null;

		try {
			model = new ProductLightTableModel(productListModel.getListProduct());
		} catch (JsonSyntaxException | IOException e1) {
			JOptionPane.showMessageDialog(productListFrame, e1.getMessage(), "Erreur lecture Liste de produits",
					JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
			model = new ProductLightTableModel(new ArrayList<ProductLight>());
		}

		productList.setModel(model);

		scrollpane = new JScrollPane(productList);

		productListPanel = new JPanel(new BorderLayout());
		productListPanel.setPreferredSize(new Dimension(400, 400));
		productListPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 10));

		productListPanel.add(scrollpane);
		productListPanel.add(createButton);
		productListPanel.add(updateButton);
		productListPanel.add(deleteButton);
		productListPanel.setLayout(new BoxLayout(productListPanel, BoxLayout.LINE_AXIS));

		productListFrame.setBounds(50, 50, 800, 600);
		productListFrame.add(productListPanel);
		productListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
}
