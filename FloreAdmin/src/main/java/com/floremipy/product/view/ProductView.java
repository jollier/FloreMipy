package com.floremipy.product.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.VetoableChangeListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.floremipy.application.view.IFramePrincipal;
import com.floremipy.product.model.Product;
import com.floremipy.product.webservice.IProductWebService;
import com.floremipy.view.CallMode;
import com.floremipy.view.IFormView;
import com.floremipy.view.RefreshCallback;
import com.floremipy.view.ReturnType;
import com.google.gson.JsonSyntaxException;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

@org.springframework.stereotype.Component(value = "productView")
public class ProductView extends JPanel implements IFormView {
	
	private static final String VIEW_NAME = "productView";
	
	@Autowired
	@Qualifier("ProductWebService")
	IProductWebService productWebService;
	
	// data
	Long id;
	Product product;
	
	// View CallMode
	private CallMode callMode;
	
	// Callback
	RefreshCallback refreshToCallback;
	
	// Swing Components
	private JTextField textname;
	private JTextField textCategory;
	private JTextArea textAreaDescription;
	private JSpinner spinner;
	
	JButton btnValider;
	JButton btnAnnuler;

	// Swing Parent Components
	IFramePrincipal mainFrame;
	JComponent panelCentral;
	CardLayout cardlayout;


	public ProductView() {
		super();
		initialize();
	}

	
	/**
	 * @wbp.parser.entryPoint
	 */
	void initialize() {

		this.setPreferredSize(new Dimension(800, 600));
		this.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 10));
		JPanel panel_1 = new JPanel();
		this.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("201dlu:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("114px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblname = new JLabel("Nom");
		panel_1.add(lblname, "2, 2, right, center");
		
		textname = new JTextField();
		panel_1.add(textname, "4, 2, fill, top");
		textname.setColumns(30);
		
		JLabel lblCategory = new JLabel("Categorie");
		panel_1.add(lblCategory, "2, 4, right, default");
		
		textCategory = new JTextField();
		panel_1.add(textCategory, "4, 4, fill, default");
		textCategory.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		panel_1.add(lblDescription, "2, 6, right, default");
		
		textAreaDescription = new JTextArea();
		textAreaDescription.setRows(10);
		panel_1.add(textAreaDescription, "4, 6, fill, top");
		
		JLabel lblQuantitEnStock = new JLabel("Quantité en stock");
		panel_1.add(lblQuantitEnStock, "2, 8, right, default");
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		panel_1.add(spinner, "4, 8, left, default");
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnValider, "2, 12");
		
		btnAnnuler = new JButton("Annuler");
		panel_1.add(btnAnnuler, "4, 12, right, default");
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}


	@Override
	public void loadData() throws IOException {
		product = productWebService.readProduct(this.id);
		mapProduct2View();
		
	}


	private void mapProduct2View() {
		if (product != null) {
			textname.setText(product.getName());
			textCategory.setText(product.getCategory());
			textAreaDescription.setText(product.getDescription());
			spinner.setValue(product.getQuantityInStock());
		}
	}

	@Override
	public void saveData() throws IOException {
		product.setName(textname.getText());
		product.setCategory(textCategory.getText());
		product.setDescription(textAreaDescription.getText());
		product.setQuantityInStock((int)spinner.getValue());
		
		if (this.callMode == CallMode.UPDATE) {
			boolean res = productWebService.updateProduct(product);
			System.out.println(res);
		} else if (this.callMode == CallMode.CREATE) {
			boolean res = productWebService.createProduct(product);
			System.out.println(res);
		}
//		if (res == true) {
//			System.out.println();
//		}
	}

	@Override
	public void addValidActionListener(ActionListener l) {
		btnValider.addActionListener(l);
		
	}


	@Override
	public void addCancelActionListener(ActionListener l) {
		btnAnnuler.addActionListener(l);
		
	}


	@Override
	public void removeAllActionListener() {
		ActionListener[] listActionListener =  btnValider.getActionListeners();
        for (int i = 0; i < listActionListener.length; i+=2) {
        	btnValider.removeActionListener(listActionListener[i]);
        }
		listActionListener =  btnAnnuler.getActionListeners();
        for (int i = 0; i < listActionListener.length; i+=2) {
        	btnAnnuler.removeActionListener(listActionListener[i]);
        }
        
        refreshToCallback = null;
	}


	public void openView(IFramePrincipal mainFrame, JComponent parent, long id) {
		this.mainFrame = mainFrame;
		this.panelCentral = parent;
		this.id = id;
		this.cardlayout = ((CardLayout)panelCentral.getLayout());
		this.panelCentral.add(VIEW_NAME,this);

		this.addValidActionListener(e1 -> {
			System.out.println("Valide productView");
			try {
				saveData();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			cardlayout.removeLayoutComponent(this);
			// Mise à jour de la liste appelante
			refreshToCallback.refreshCallback(ReturnType.VALID);
			this.removeAllActionListener();
			
			//panelCentral.closeView(this);
		});
		this.addCancelActionListener(e1 -> {
			System.out.println("Abandonne productView");
			cardlayout.removeLayoutComponent(this);
			refreshToCallback.refreshCallback(ReturnType.CANCEL);
			this.removeAllActionListener();
			//framePrincipal.closeView(productView);
		});

		if (this.callMode == CallMode.UPDATE) {
		try {
		
			this.loadData();
		} catch (JsonSyntaxException | IOException e) {
			// TODO Auto-generated catch block
			// Mise à jour du status
			e.printStackTrace();
		}
		} else if (this.callMode == CallMode.CREATE) {
			this.product = new Product(0,"","","",0);
			mapProduct2View();
		}

		
		cardlayout.show(panelCentral, VIEW_NAME);
		
	}


	@Override
	public void update(IFramePrincipal mainFrame, JComponent parent, Long id) {
		this.callMode = CallMode.UPDATE;
		openView(mainFrame, parent, id);
		mainFrame.setStatus("Modification du produit");
		
	}


	@Override
	public void create(IFramePrincipal mainFrame, JComponent parent) {
		this.callMode = CallMode.CREATE;
		openView(mainFrame, parent, 0L);
		mainFrame.setStatus("Création du produit");
		
	}




	@Override
	public void registerRefreshCallback(RefreshCallback r) {
		// Action qui est déclenchée après la mise à jour de données et après la fermeture de la fenêtre
		refreshToCallback = r;
		
	}



	@Override
	public void setStatus(String s) {
		this.mainFrame.setStatus(s);
		
	}









}
