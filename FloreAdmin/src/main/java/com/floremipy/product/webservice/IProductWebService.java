package com.floremipy.product.webservice;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.floremipy.product.model.Product;
import com.floremipy.product.model.ProductLight;
import com.google.gson.JsonSyntaxException;


public interface IProductWebService {

	ArrayList<ProductLight> getAllProductLight() throws  MalformedURLException, UnsupportedEncodingException, IOException;
	
	public void createProduct(Product product);
	public Product readProduct(Long Id) throws JsonSyntaxException, UnsupportedEncodingException, IOException;
	public void updateProduct(Long Id);
	public Product deleteProduct(Long Id);

}