package com.floremipy.product.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.floremipy.application.view.IFramePrincipal;
import com.floremipy.controller.IControler;
import com.floremipy.product.model.Alert;
import com.floremipy.product.model.IProductListModel;
import com.floremipy.product.model.ProductLight;
import com.floremipy.product.model.ProductLightTableModel;
import com.floremipy.product.webservice.IProductWebService;
import com.floremipy.view.CallMode;
import com.floremipy.view.IFormView;
import com.floremipy.view.IListView;
import com.floremipy.view.IView;
import com.floremipy.view.ReturnType;
import com.floremipy.view.StatusSetter;
import com.google.gson.JsonSyntaxException;

@org.springframework.stereotype.Component(value = "productListView")
public class ProductListView extends JPanel implements IListView {

	private static final String VIEW_NAME = "productListView";

	// @Autowired
	public Logger log4j;

	@Autowired
	@Qualifier("productView")
	IFormView productView;

	@Autowired
	@Qualifier("ProductListModel")
	IProductListModel productListModel;

	@Autowired
	@Qualifier("ProductWebService")
	IProductWebService productWebService;

	ArrayList<ProductLight> listProduct;

	IFramePrincipal mainFrame;
	JComponent panelCentral;
	CardLayout cardlayout;

	CallMode FormCallMode = null;

	boolean ready = false;

	public ProductListView() {
		super();
		initialize();
	}

	public JScrollPane scrollpane = null;
	public JTable productList = null;
	public JButton createButton = null;
	public JButton updateButton = null;
	public JButton deleteButton = null;
	public JTextPane textPane = null;

	/**
	 * @wbp.parser.entryPoint
	 */
	void initialize() {

		log4j = Logger.getLogger(ProductListView.class);
		log4j.info("Initialisation");

		textPane = new JTextPane();

		productList = new JTable();

		ProductLightTableModel model = null;

		textPane.setText("Liste de produits");

		scrollpane = new JScrollPane(productList);

		this.setPreferredSize(new Dimension(800, 600));
		this.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 10));

		this.add(scrollpane, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		this.add(panel_1, BorderLayout.NORTH);

		createButton = new JButton("Create");
		panel_1.add(createButton);

		updateButton = new JButton("Update");
		panel_1.add(updateButton);
		updateButton.setEnabled(false);

		deleteButton = new JButton("Delete");
		panel_1.add(deleteButton);
		deleteButton.setEnabled(false);

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.floremipy.product.view.IListView#loadData()
	 */
	@Override
	public void loadData() {
		ProductLightTableModel model;
		try {
			ArrayList<ProductLight> ProductList = productListModel.getListProduct();
			ProductLightTableModel modeltest = new ProductLightTableModel(ProductList);
			model = modeltest;
		} catch (JsonSyntaxException | IOException e1) {
			JOptionPane.showMessageDialog(this, e1.getLocalizedMessage(), "Erreur lecture Liste de produits",
					JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
			log4j.error("Erreur lecture Liste de produits", e1);
			this.mainFrame.setStatus("Erreur lecture Liste de produits");
			model = new ProductLightTableModel(new ArrayList<ProductLight>());
		}

		// productList.setDefaultRenderer(Alert.class, new
		// SimpleIconRenderer());
		// productList.getColumnModel().getColumn(3).setCellRenderer(new
		// SimpleIconRenderer());
		productList.setRowHeight(35);
		productList.setModel(model);

		TableColumn column = productList.getColumnModel().getColumn(2);
		column.setMinWidth(100);
		column.setMaxWidth(100);
		column.setWidth(100);
		column.setPreferredWidth(100);

		column = productList.getColumnModel().getColumn(3);
		column.setMinWidth(100);
		column.setMaxWidth(100);
		column.setWidth(100);
		column.setPreferredWidth(100);
		column.setCellRenderer(new SimpleIconRenderer());

		column = productList.getColumnModel().getColumn(4);
		column.setMinWidth(0);
		column.setMaxWidth(0);
		column.setWidth(0);
		column.setPreferredWidth(0);

		if (model.getRowCount() > 0) {
			updateButton.setEnabled(true);
			deleteButton.setEnabled(true);
		} else {
			updateButton.setEnabled(false);
			deleteButton.setEnabled(false);
		}

	}

	@Override
	public void addCreateActionListener(ActionListener l) {
		createButton.addActionListener(l);

	}

	@Override
	public void addUpdateActionListener(ActionListener l) {
		updateButton.addActionListener(l);

	}

	@Override
	public void addDeleteActionListener(ActionListener l) {
		deleteButton.addActionListener(l);

	}

	@Override
	public void removeAllActionListener() {
		ActionListener[] listActionListener = createButton.getActionListeners();
		for (int i = 0; i < listActionListener.length; i += 2) {
			createButton.removeActionListener(listActionListener[i]);
		}
		listActionListener = updateButton.getActionListeners();
		for (int i = 0; i < listActionListener.length; i += 2) {
			updateButton.removeActionListener(listActionListener[i]);
		}
		listActionListener = deleteButton.getActionListeners();
		for (int i = 0; i < listActionListener.length; i += 2) {
			deleteButton.removeActionListener(listActionListener[i]);
		}

	}

	@Override
	public void openView(IFramePrincipal mainFrame, JComponent parent) {
		this.mainFrame = mainFrame;
		panelCentral = parent;
		cardlayout = ((CardLayout) panelCentral.getLayout());
		panelCentral.add(VIEW_NAME, this);
		this.mainFrame.setStatus("Liste de produits");

		this.addCreateActionListener(e -> {
			productView.registerRefreshCallback(this);
			productView.create(this.mainFrame, parent);

		});

		this.addUpdateActionListener(e -> {
			int rowSelected = productList.getSelectedRow();
			if (rowSelected != -1) {
				long id = (long) productList.getValueAt(rowSelected, 4);
				productView.registerRefreshCallback(this);
				productView.update(this.mainFrame, parent, id);
			}

		});

		this.addDeleteActionListener(e -> {
			boolean res = false;
			int rowSelected = productList.getSelectedRow();
			if (rowSelected != -1) {
				long id = (long) productList.getValueAt(rowSelected, 4);
				if (id > 0) {
					try {
						res = productWebService.deleteProduct(id);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (res) {
						((ProductLightTableModel) productList.getModel()).removeRow(rowSelected);

					}
				}
			}
		});

		this.loadData();

		cardlayout.show(panelCentral, VIEW_NAME);

	}

	@Override
	public void refreshCallback(ReturnType rt) {

		if (rt.equals(ReturnType.VALID)) {
			// Mise à jour de la liste
			loadData();
		}
		this.setStatus("Liste de produits");

	}

	@Override
	public void setStatus(String s) {
		this.mainFrame.setStatus(s);

	}

}
