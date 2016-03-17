package com.floremipy.application.view;

import javax.swing.JComponent;
import javax.swing.JPanel;

public interface IFramePrincipal {
	
	public void view();
	public JPanel getPanelCentral();
	
	public void setStatus(String status);
}
