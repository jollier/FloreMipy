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

import com.floremipy.product.model.ProductLight;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ProductWebService {

    private static final String SITEURL = "localhost:8080/";
    //private static final String SITEURL = "http://locomaps.cloudapp.net/LocoMaps/";

	public ArrayList<ProductLight> getAllProductLight() {
		  ArrayList<ProductLight> response = new ArrayList<ProductLight>();

          HttpURLConnection conn = null;
          try {

              //URL url = new URL("http://www.locomaps.com/user/getAllUser");
              //URL url = new URL("localhost:8080/LocoMaps/user/getAllUser");
              URL url = new URL(SITEURL + "product?Lightlist");

              response = JsonUtils.listProductLightRequest(url);


          } catch (IOException e) {
              e.printStackTrace();
              return null;
          }

      return response;
	}

	

}
