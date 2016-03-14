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

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;
import org.springframework.beans.factory.annotation.Autowired;


import com.floremipy.product.model.IProductListModel;
import com.floremipy.product.model.ProductLight;
import com.floremipy.product.model.ProductLightTableModel;
import com.google.gson.JsonSyntaxException;

import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;

//@org.springframework.stereotype.Component
public class ProductListView extends Observable implements Observer {

	@Autowired
	public Logger log4j;
	
	IProductListModel productListModel;
	ArrayList<ProductLight> listProduct;

	boolean ready = false;

	public ProductListView(IProductListModel productListModel) {
		super();
		this.productListModel = productListModel;
		log4j = Logger.getLogger(ProductListView.class);
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

	/**
	 * @wbp.parser.entryPoint
	 */
	void initialize() {

		log4j.info("Initialisation");
		productListFrame = new JFrame();

		JTextPane textPane = new JTextPane();
		productList = new JTable();

		ProductLightTableModel model = null;

		textPane.setText("Liste de produits");
		try {
			model = new ProductLightTableModel(productListModel.getListProduct());
		} catch (JsonSyntaxException | IOException e1) {
			JOptionPane.showMessageDialog(productListFrame, e1.getMessage(), "Erreur lecture Liste de produits",
					JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
			log4j.error("Erreur lecture Liste de produits", e1);
			textPane.setText("Erreur lecture Liste de produits");
			model = new ProductLightTableModel(new ArrayList<ProductLight>());
		}

		productList.setModel(model);

		scrollpane = new JScrollPane(productList);

		productListPanel = new JPanel(new BorderLayout());
		productListPanel.setPreferredSize(new Dimension(402, 400));
		productListPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 10));

		productListPanel.add(scrollpane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		productListPanel.add(panel_1, BorderLayout.NORTH);
		
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
		productListPanel.setLayout(new BoxLayout(productListPanel, BoxLayout.PAGE_AXIS));

		productListFrame.setBounds(50, 50, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		productListFrame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnPrincipal = new JMenu("Menu Navigation");
		menuBar.add(mnPrincipal);
		
		JMenuItem mntmAccueil = new JMenuItem("Accueil");
		mnPrincipal.add(mntmAccueil);
		
		JMenuItem mntmListProduct = new JMenuItem("Liste des produits");
		mnPrincipal.add(mntmListProduct);
		productListFrame.getContentPane().add(productListPanel);
		
		JSeparator separator = new JSeparator();
		mnPrincipal.add(separator);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.setAction(new AbstractAction("Quit") {
			public void actionPerformed(ActionEvent e) {
//				setChanged();
//				notifyObservers(XXGameCtrl.ACTION_COMMAND_KEY_PAUSE);
				productListFrame.dispose();
			}
		});
		mnPrincipal.add(mntmQuit);
		
		JPanel panel = new JPanel();
		productListFrame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		
		JSeparator separator_1 = new JSeparator();
		panel.add(separator_1, BorderLayout.NORTH);
		
		panel.add(textPane, BorderLayout.SOUTH);

		
		productListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



		
		//		
//		JMenuBar mb = new JMenuBar();
//		JMenu fileMenu = new JMenu("File");
//		fileMenu.add(new ShowDialogAction());
//		fileMenu.add(new ExitAction());
//		mb.add (fileMenu);
//		setJMenuBar (mb);

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
}
