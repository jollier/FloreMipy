package com.floremipy.view;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.swing.JComponent;

import com.google.gson.JsonSyntaxException;

public interface IFormView extends IView {

	void loadData() throws JsonSyntaxException, UnsupportedEncodingException, IOException;
	void saveData();
	
	public void update(JComponent parent,Long id);
	public void create(JComponent parent);
	
	public void addValidActionListener(ActionListener l);
	public void addCancelActionListener(ActionListener l);
	



}
