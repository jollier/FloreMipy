package com.floremipy.product.webservice;

import java.awt.Image;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.floremipy.product.model.Product;
import com.floremipy.product.model.ProductLight;

@Component(value="ProductWebService")
public class ProductWebService implements IProductWebService {

	private static final String SITEURL = "http://localhost:8080/FloreMipy/";
	
	@Autowired
	JsonUtils jsonUtils;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.floremipy.product.webservice.IProductWebService#getAllProductLight()
	 */
	@Override
	public ArrayList<ProductLight> getAllProductLight() throws IOException {
		ArrayList<ProductLight> response = new ArrayList<ProductLight>();

		//JsonUtils jsonUtils = new JsonUtils();
		
		URL url = new URL(SITEURL + "Product/list");
		HttpURLConnection conn = jsonUtils.getConnexion(url);
		response = jsonUtils.listProductLightRequest(conn);

		return response;
	}


	
	public ProductWebService() {

	}

	@Override
	public boolean createProduct(Product product) throws IOException {
		URL url = new URL(SITEURL + "Product/add");
		HttpURLConnection conn = jsonUtils.getConnexion(url);
		boolean response = jsonUtils.productCreateRequest(conn, product);

		return response;
		
	}

	@Override
	public Product readProduct(Long Id) throws IOException {
		Product response;
		URL url = new URL(SITEURL + "Product/item" + Id);
		HttpURLConnection conn = jsonUtils.getConnexion(url);
		response = jsonUtils.productReadRequest(conn);

		return response;
	}

	@Override
	public boolean updateProduct(Product product) throws IOException {
		URL url = new URL(SITEURL + "Product/update");
		HttpURLConnection conn = jsonUtils.getConnexion(url);
		boolean response = jsonUtils.productUpdateRequest(conn, product);

		return response;
		
	}



	@Override
	public boolean deleteProduct(Long Id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Image getImageProduct(String imgsrc) throws IOException {
		URL url = new URL(SITEURL + imgsrc);
		Image response = jsonUtils.getImageProductRequest(url);

		return response;
	}

	

}
