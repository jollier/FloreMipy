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

//import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.core.env.Environment;

import com.floremipy.product.model.Product;
import com.floremipy.product.model.ProductLight;
import com.floremipy.view.IFormView;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

@Component(value="ProductWebService")
public class ProductWebService implements IProductWebService {

	//private static final String SITEURL = "http://localhost:8080/FloreMipy/";
	//private static String SITEURL = "http://localhost:8080/FloreMipy/";
	
	@Autowired
	JsonUtils jsonUtils;
	
    @Value("${site.url}")
    private String SITEURL;

	//@Autowired
	//Environment environment;

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
		//SITEURL = //environment.getProperty("site.url");
		//System.out.println(SITEURL);
		//SITEURL = System.getProperty("site.url");
		//java.util.Properties props = new java.util.Properties();
		//SITEURL = props.getProperty("site.url");
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


	

}
