package com.floremipy.product.webservice;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.floremipy.product.model.ProductLight;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonUtils {

	HttpURLConnection conn;

	public JsonUtils(HttpURLConnection conn) {
		super();
		this.conn = conn;
	}

	public JsonUtils() {
		super();
	}

	public HttpURLConnection getConn() {
		return conn;
	}

	public void setConn(HttpURLConnection conn) {
		this.conn = conn;
	}

	public ArrayList<ProductLight> listProductLightRequest(HttpURLConnection conn)
			throws IOException, UnsupportedEncodingException {
		ArrayList<ProductLight> response;
		String responseStr;
		this.conn = conn;

		// *************** Stub HttpURLConnection **************
		MockitoAnnotations.initMocks(this);
		this.conn = Mockito.mock(HttpURLConnection.class);
		String jsonExpected = "[{\"id\":1,\"category\":\"Conifère\",\"description\":\"\",\"name\":\"Sapin\",\"quantityInStock\":5,\"alertLotMature\":1},"
				+ "{\"id\":2,\"category\":\"Fagacées\",\"description\":\"\",\"name\":\"Chêne\",\"quantityInStock\":10,\"alertLotMature\":0}]";
		InputStream ProductLightJsonExpected = null;

		ProductLightJsonExpected = new ByteArrayInputStream(jsonExpected.getBytes("UTF-8"));

		Mockito.when(this.conn.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
		Mockito.when(this.conn.getInputStream()).thenReturn(ProductLightJsonExpected);
		
		// *************** Fin du Stub **************

		this.conn.connect();

		// expect HTTP 200 OK, so we don't mistakenly save error report
		// instead of the file
		if (this.conn.getResponseCode() != HttpURLConnection.HTTP_OK) {

			return null; 
			// "Server returned HTTP " +
			// connection.getResponseCode() + " " +
			// connection.getResponseMessage();
		}

		InputStream is = this.conn.getInputStream();
		BufferedReader streamReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		StringBuilder responseStrBuilder = new StringBuilder();

		String inputStr;
		while ((inputStr = streamReader.readLine()) != null)
			responseStrBuilder.append(inputStr);

		responseStr = responseStrBuilder.toString();
		Type listType = new TypeToken<ArrayList<ProductLight>>() {
		}.getType();
		response = new Gson().fromJson(responseStr, listType);
		return response;
	}
}
