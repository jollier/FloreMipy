package com.floremipy.view;

import javax.swing.JComponent;

import com.floremipy.controller.IControler;

public interface IView {

	public void openView(JComponent parent, long id);
	public void openView(JComponent parent);	//public void setControler(IControler controler);
	
	public void closeView();
	
	public void removeAllActionListener();
	
	//	public void addView(JComponent parent, String name, JComponent component);
//	public void setActiveView(String name);
//	public void deleteView(JComponent component);
}
