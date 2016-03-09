package com.floremipy.product.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.floremipy.product.model.ProductLight;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Component
public class ProductWebService implements IProductWebService {

	private static final String SITEURL = "http://localhost:8080/FloreMipy/";
	// private static final String SITEURL =
	// "http://locomaps.cloudapp.net/LocoMaps/";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.floremipy.product.webservice.IProductWebService#getAllProductLight()
	 */
	@Override
	public ArrayList<ProductLight> getAllProductLight() {
		ArrayList<ProductLight> response = new ArrayList<ProductLight>();

		// HttpURLConnection conn = null;
		JsonUtils jsonUtils = new JsonUtils();
		try {

			URL url = new URL(SITEURL + "Product/list");
			HttpURLConnection conn;
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(2000);
			conn.setReadTimeout(10000);
			response = jsonUtils.listProductLightRequest(conn);

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		return response;
	}

}
