package com.floremipy.product.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.floremipy.product.model.Product;
import com.floremipy.product.model.ProductLight;
import com.floremipy.view.IFormView;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

@Component(value="ProductWebService")
public class ProductWebService implements IProductWebService {

	private static final String SITEURL = "http://localhost:8080/FloreMipy/";
	
	@Autowired
	JsonUtils jsonUtils;
	
	// private static final String SITEURL =
	// "http://locomaps.cloudapp.net/LocoMaps/";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.floremipy.product.webservice.IProductWebService#getAllProductLight()
	 */
	@Override
	public ArrayList<ProductLight> getAllProductLight() throws MalformedURLException, UnsupportedEncodingException, IOException {
		ArrayList<ProductLight> response = new ArrayList<ProductLight>();

		//JsonUtils jsonUtils = new JsonUtils();
		
		URL url = new URL(SITEURL + "Product/list");
		HttpURLConnection conn = jsonUtils.getConnexion(url);
		response = jsonUtils.listProductLightRequest(conn);

		return response;
	}


	
	public ProductWebService() {
		//super();
	}

	@Override
	public void createProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product readProduct(Long Id) throws JsonSyntaxException, UnsupportedEncodingException, IOException {
		Product response;
		URL url = new URL(SITEURL + "Product/item" + Id);
		HttpURLConnection conn = jsonUtils.getConnexion(url);
		response = jsonUtils.ProductRequest(conn);

		return response;
	}

	@Override
	public void updateProduct(Long Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product deleteProduct(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
