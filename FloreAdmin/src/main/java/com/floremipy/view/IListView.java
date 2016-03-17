package com.floremipy.view;

import java.awt.event.ActionListener;

public interface IListView extends IView {

	void loadData();
	
	public void addCreateActionListener(ActionListener l);
	public void addUpdateActionListener(ActionListener l);
	public void addDeleteActionListener(ActionListener l);
	



}