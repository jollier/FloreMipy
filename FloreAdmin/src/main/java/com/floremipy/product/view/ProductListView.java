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
import javax.swing.JTextPane;
import javax.swing.table.TableModel;

import org.apache.log4j.Appender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.floremipy.product.model.IProductListModel;
import com.floremipy.product.model.ProductLight;
import com.floremipy.product.model.ProductLightTableModel;
import com.google.gson.JsonSyntaxException;

//@org.springframework.stereotype.Component
@org.springframework.stereotype.Component(value = "productListView")
public class ProductListView extends JPanel implements IListView {

	// @Autowired
	public Logger log4j;

	@Autowired
	@Qualifier("ProductListModel")
	IProductListModel productListModel;

	ArrayList<ProductLight> listProduct;

	boolean ready = false;


	public ProductListView() {
		super();
		initialize();
	}

	// JFrame productListFrame = null;
	// JPanel productListPanel = null;

	public JScrollPane scrollpane = null;
	public JTable productList = null;
	public JButton createButton = null;
	public JButton updateButton = null;
	public JButton deleteButton = null;
	public JTextPane textPane = null;

	// public void view() {
	// initialize();
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// /*
	// * Lance le thread de la fenetre et la lecture des touches
	// * du clavier
	// */
	//
	// ready = true;
	// productListFrame.setVisible(true);
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	//
	// }

	/**
	 * @wbp.parser.entryPoint
	 */
	void initialize() {

		log4j = Logger.getLogger(ProductListView.class);
		log4j.info("Initialisation");
		// productListFrame = new JFrame();

		textPane = new JTextPane();

		productList = new JTable();

		updateButton = new JButton("Update");
		updateButton.setEnabled(false);
		updateButton.addActionListener(e -> System.out.println("updateButton"));

		deleteButton = new JButton("Delete");
		deleteButton.setEnabled(false);
		deleteButton.addActionListener(e -> System.out.println("deleteButton"));

		productList = new JTable();
		ProductLightTableModel model = null;

		textPane.setText("Liste de produits");

		scrollpane = new JScrollPane(productList);

		// productListPanel = new JPanel(new BorderLayout());
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
		deleteButton.addActionListener(e -> System.out.println("deleteButton"));
		updateButton.addActionListener(e -> System.out.println("updateButton"));
		// createButton.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// System.out.println("createButton");
		// }});
		createButton.addActionListener(e -> System.out.println("createButton"));
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));


	}

	/* (non-Javadoc)
	 * @see com.floremipy.product.view.IListView#loadData()
	 */
	@Override
	public void loadData() {
		ProductLightTableModel model;
		try {
			//ArrayList<ProductLight> ProductList = new ArrayList<ProductLight>();
			ArrayList<ProductLight> ProductList = productListModel.getListProduct();
//			for (ProductLight productLight : ProductList) {
//				System.out.println("productLight " + productLight);
//			}
			ProductLightTableModel modeltest = new ProductLightTableModel(ProductList);
			model = modeltest;
		} catch (JsonSyntaxException | IOException e1) {
			JOptionPane.showMessageDialog(this, e1.getLocalizedMessage(), "Erreur lecture Liste de produits",
					JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
			log4j.error("Erreur lecture Liste de produits", e1);
			textPane.setText("Erreur lecture Liste de produits");
			model = new ProductLightTableModel(new ArrayList<ProductLight>());
		}

		productList.setModel(model);
	}

	// public IProductListModel getProductListModel() {
	// return productListModel;
	// }
	//
	//
	// public void setProductListModel(IProductListModel productListModel) {
	// System.out.println("setProductListModel " + productListModel);
	// this.productListModel = productListModel;
	// initialize();
	// }

}
