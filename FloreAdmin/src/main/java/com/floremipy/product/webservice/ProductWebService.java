package com.floremipy.product.webservice;

import java.awt.Image;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

//import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.core.env.Environment;


import com.floremipy.product.model.Product;
import com.floremipy.product.model.ProductLight;

@Component(value="ProductWebService")
public class ProductWebService implements IProductWebService {

	@Autowired
	JsonUtils jsonUtils;
	
    @Value("${site.url}")
    private String SITEURL;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.floremipy.product.webservice.IProductWebService#getAllProductLight()
	 */
	@Override
	public ArrayList<ProductLight> getAllProductLight() throws IOException {
		ArrayList<ProductLight> response = new ArrayList<ProductLight>();

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
	public boolean deleteProduct(Long Id) throws IOException {
		URL url = new URL(SITEURL + "Product/delete/" + Id);
		HttpURLConnection conn = jsonUtils.getConnexion(url);
		boolean response = jsonUtils.productDeleteRequest(conn);

		return response;
		
	}
	
	@Override
	public Image getImageProduct(String imgsrc) throws IOException {
		URL url = new URL(SITEURL + imgsrc);
		Image response = jsonUtils.getImageProductRequest(url);

		return response;
	}
	
	public boolean uploadImage(String imageFile) throws IOException {
		URL url = new URL(SITEURL + "Product/uploadImage");
		HttpURLConnection conn = jsonUtils.getConnexion(url);
		boolean response = jsonUtils.productImageUpdatePost(conn, imageFile);
		return false;
	}

	

}
