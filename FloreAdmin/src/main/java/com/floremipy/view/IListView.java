package com.floremipy.view;

import java.awt.event.ActionListener;

import javax.swing.JComponent;

import com.floremipy.application.view.IFramePrincipal;

public interface IListView extends IView, RefreshCallback {

	public void openView(IFramePrincipal mainFrame, JComponent parent);
	
	void loadData();
	
	public void addCreateActionListener(ActionListener l);
	public void addUpdateActionListener(ActionListener l);
	public void addDeleteActionListener(ActionListener l);
	



}