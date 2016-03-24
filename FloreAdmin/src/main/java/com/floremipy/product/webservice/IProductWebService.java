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
	
	public boolean createProduct(Product product) throws IOException;
	public Product readProduct(Long Id) throws IOException;
	public boolean updateProduct(Product product) throws IOException;
	public boolean deleteProduct(Long Id);

}