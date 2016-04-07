package com.floremipy.product.webservice;

import java.awt.Image;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.floremipy.product.model.Product;
import com.floremipy.product.model.ProductLight;


public interface IProductWebService {

	ArrayList<ProductLight> getAllProductLight() throws  MalformedURLException, UnsupportedEncodingException, IOException;
	
	public boolean createProduct(Product product) throws IOException;
	public Product readProduct(Long Id) throws IOException;
	public boolean updateProduct(Product product) throws IOException;
	public boolean deleteProduct(Long Id) throws IOException;
	public Image getImageProduct(String imgsrc) throws IOException;
	public boolean uploadImage(String imageFile) throws IOException;

}