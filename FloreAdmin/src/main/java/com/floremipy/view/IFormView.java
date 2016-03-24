package com.floremipy.view;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.swing.JComponent;

import com.floremipy.application.view.IFramePrincipal;
import com.floremipy.product.model.Product;
import com.google.gson.JsonSyntaxException;

public interface IFormView extends IView {

	
	void loadData() throws IOException;
	void saveData() throws IOException;
	
	public void update(IFramePrincipal mainFrame, JComponent parent,Long id);
	public void create(IFramePrincipal mainFrame, JComponent parent);
	
	public void addValidActionListener(ActionListener l);
	public void addCancelActionListener(ActionListener l);
	
	public void registerRefreshCallback(RefreshCallback r);



}
