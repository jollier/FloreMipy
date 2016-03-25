package com.floremipy.view;

import javax.swing.JComponent;

import com.floremipy.controller.IControler;

public interface IView extends StatusSetter{

	//public void RegisterStatusSetter(StatusSetter st);

	//public void setControler(IControler controler);
	
	//public void closeView();
	
	public void removeAllActionListener();
	
	//	public void addView(JComponent parent, String name, JComponent component);
//	public void setActiveView(String name);
//	public void deleteView(JComponent component);
}
