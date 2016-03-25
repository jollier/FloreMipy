package com.floremipy.application.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextPane;

import org.springframework.stereotype.Component;

import com.floremipy.product.model.ProductLight;
import com.floremipy.product.model.ProductLightTableModel;
import com.floremipy.view.StatusSetter;
import com.google.gson.JsonSyntaxException;
import java.awt.CardLayout;

@Component(value="Main")
public class MainFrame implements IFramePrincipal {

	JFrame frame = null;
	JPanel panelGeneral = null;
	JPanel panelCentral = null;
	
	JPanel panelStatus = null;
	JTextPane textPane = null;
	
	boolean ready = false;
	
	
	
	public MainFrame() {
		super();
		initialize();
	}


	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {

		System.out.println("MainFrame.initialize");

		frame = new JFrame();
	
		textPane = new JTextPane();
		
//		productList = new JTable();
//
//		ProductLightTableModel model = null;

		textPane.setText("Liste de produits");
//		try {
//			model = new ProductLightTableModel(productListModel.getListProduct());
//		} catch (JsonSyntaxException | IOException e1) {
//			JOptionPane.showMessageDialog(frame, e1.getLocalizedMessage(), "Erreur lecture Liste de produits",
//					JOptionPane.ERROR_MESSAGE);
//			e1.printStackTrace();
//			log4j.error("Erreur lecture Liste de produits", e1);
//			textPane.setText("Erreur lecture Liste de produits");
//			model = new ProductLightTableModel(new ArrayList<ProductLight>());
//		}
//
//		productList.setModel(model);
//
//		scrollpane = new JScrollPane(productList);

//		productListPanel = new JPanel(new BorderLayout());
//		productListPanel.setPreferredSize(new Dimension(402, 400));
//		productListPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 10));
//
//		productListPanel.add(scrollpane, BorderLayout.CENTER);
		
//		JPanel panel_1 = new JPanel();
//		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
//		flowLayout_1.setAlignment(FlowLayout.LEFT);
//		productListPanel.add(panel_1, BorderLayout.NORTH);
//		
//				createButton = new JButton("Create");
//				panel_1.add(createButton);
//				
//						updateButton = new JButton("Update");
//						panel_1.add(updateButton);
//						updateButton.setEnabled(false);
//						
//								deleteButton = new JButton("Delete");
//								panel_1.add(deleteButton);
//								deleteButton.setEnabled(false);
//								deleteButton.addActionListener(e -> System.out.println("deleteButton"));
//						updateButton.addActionListener(e -> System.out.println("updateButton"));
//				// createButton.addActionListener(new ActionListener() {
//				// @Override
//				// public void actionPerformed(ActionEvent e) {
//				// System.out.println("createButton");
//				// }});
//				createButton.addActionListener(e -> System.out.println("createButton"));
//		productListPanel.setLayout(new BoxLayout(productListPanel, BoxLayout.PAGE_AXIS));

		
		
		
		
		
		
		
		frame.setBounds(50, 50, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnPrincipal = new JMenu("Menu Navigation");
		menuBar.add(mnPrincipal);
		
		JMenuItem mntmAccueil = new JMenuItem("Accueil");
		mnPrincipal.add(mntmAccueil);
		
		JMenuItem mntmListProduct = new JMenuItem("Liste des produits");
		mnPrincipal.add(mntmListProduct);
		
		//frame.getContentPane().add(productListPanel);
		
		JSeparator separator = new JSeparator();
		mnPrincipal.add(separator);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.setAction(new AbstractAction("Quit") {
			public void actionPerformed(ActionEvent e) {
//				setChanged();
//				notifyObservers(XXGameCtrl.ACTION_COMMAND_KEY_PAUSE);
				frame.dispose();
			}
		});
		mnPrincipal.add(mntmQuit);
		
		panelCentral = new JPanel();
		frame.getContentPane().add(panelCentral, BorderLayout.WEST);
		panelCentral.setLayout(new CardLayout(0, 0));
		
		panelStatus = new JPanel();
		frame.getContentPane().add(panelStatus, BorderLayout.SOUTH);
		panelStatus.setLayout(new BorderLayout(0, 0));
		
		JSeparator separator_1 = new JSeparator();
		panelStatus.add(separator_1, BorderLayout.NORTH);
		
		panelStatus.add(textPane, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}


//	@Override
//	public void addView(String name, JComponent component) {
//		System.out.println("addView : " + name + " / " + component);
//		System.out.println("panelCentral : " + panelCentral);
//		panelCentral.add(name,component);
//		
//	}
//
//	@Override
//	public void setActiveView(String name) {
//		System.out.println("setActiveView " +name );
//		((CardLayout)panelCentral.getLayout()).show(panelCentral, name);
//		
//	}
//
//	@Override
//	public void deleteView(JComponent component) {
//		((CardLayout)panelCentral.getLayout()).removeLayoutComponent(component);
//		
//	}

	@Override
	public void view() {
		//initialize();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*
					 * Lance le thread de la fenetre et la lecture des touches
					 * du clavier
					 */

					ready = true;
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		
	}

	@Override
	public JPanel getPanelCentral() {
		return panelCentral;
	}


	@Override
	public void setStatus(String status) {
		textPane.setText(status);
		
	}
}
