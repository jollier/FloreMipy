package com.floremipy.application.view;

import javax.swing.JComponent;

public interface FramePrincipal {

	public void addView(String name, JComponent component);
	public void setActiveView(String name);
	public void deleteView(JComponent component);
	
	public void view();
	
	public void setStatus(String status);
}
