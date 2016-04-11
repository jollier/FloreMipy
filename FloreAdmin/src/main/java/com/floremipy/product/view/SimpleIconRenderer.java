package com.floremipy.product.view;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class SimpleIconRenderer extends DefaultTableCellRenderer {
	
	  //private TableCellRenderer delegate;
	
	  private Icon icon;
	
	 
	
	  public SimpleIconRenderer()
	
	  {
	
	    //this.delegate = defaultRenderer;
	
	    icon = UIManager.getIcon("OptionPane.warningIcon");//new ImageIcon(this.getClass().getResource("/demo/tablecellrenderer/accept.png"));
	
	  }
	
	 
	
	  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	
	  {
	
	    //Component c = delegate.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		setHorizontalAlignment( JLabel.CENTER );
	    if ((int)value == 1) setIcon(icon);
	    else setIcon(null);
	
	    return this;
	
	  }

}
