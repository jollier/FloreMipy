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

import org.mockito.InjectMocks;

import com.floremipy.product.model.ProductLight;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonUtils {

	public static ArrayList<ProductLight> listProductLightRequest(URL url) throws IOException, UnsupportedEncodingException {
		ArrayList<ProductLight> response;
		HttpURLConnection conn;
		conn = (HttpURLConnection) url.openConnection();
		  conn.setConnectTimeout(2000);
		  conn.setReadTimeout(10000);
		  conn.connect();

		  // expect HTTP 200 OK, so we don't mistakenly save error report
		  // instead of the file
		  if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
		      
		      return null;  //"Server returned HTTP " + connection.getResponseCode() + " " + connection.getResponseMessage();
		  }


		  InputStream is = conn.getInputStream();
		  BufferedReader streamReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		  StringBuilder responseStrBuilder = new StringBuilder();

		  String inputStr;
		  while ((inputStr = streamReader.readLine()) != null)
		      responseStrBuilder.append(inputStr);

		  Type listType = new TypeToken<ArrayList<ProductLight>>() {
		  }.getType();
		  response = new Gson().fromJson(responseStrBuilder.toString(), listType);
		return response;
	}
}
