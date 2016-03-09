package com.floremipy.product.webservice;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.floremipy.product.model.ProductLight;
import com.floremipy.product.webservice.JsonUtils;
import com.floremipy.product.webservice.ProductWebService;

//@RunWith(MockitoJUnitRunner.class)
public class JsonUtilsTest {

	private static final String SITEURL = "http://localhost:8080/";

	ArrayList<ProductLight> listProductExpected;

	//@Mock
	URL url;
	
	@Mock
	HttpURLConnection conn;
	
	@InjectMocks
	JsonUtils jsonUtils;
	
	@Before
	public void beforeTest() {
		MockitoAnnotations.initMocks(this);

		
		//URL url  = Mockito.mock(URL.class);
		//HttpURLConnection conn  = Mockito.mock(HttpURLConnection.class);

		//@InjectMocks
		//JsonUtils 
		jsonUtils = new JsonUtils();

		listProductExpected = new ArrayList<ProductLight>();

		ProductLight p;
		p = new ProductLight(1L, "Sapin", "Conifère", 5, 1);
		listProductExpected.add(p);
		p = new ProductLight(2L, "Chêne", "Fagacées", 10, 0);
		listProductExpected.add(p);

		String jsonExpected = "[{\"id\":1,\"category\":\"Conifère\",\"description\":\"\",\"name\":\"Sapin\",\"quantityInStock\":5,\"alertLotMature\":1},"
				+ "{\"id\":2,\"category\":\"Fagacées\",\"description\":\"\",\"name\":\"Chêne\",\"quantityInStock\":10,\"alertLotMature\":0}]";

		InputStream ProductLightJsonExpected = null;
		try {
			ProductLightJsonExpected = new ByteArrayInputStream(jsonExpected.getBytes("UTF-8"));

			Mockito.when(conn.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
			Mockito.when(conn.getInputStream()).thenReturn(ProductLightJsonExpected);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void listProductLightRequestTest() throws IOException {

		ArrayList<ProductLight> listProduct;
		// JsonUtils jsonUtils = new JsonUtils();

		// ProductLightJsonExpected.read();

		// URL url = Mockito.mock(URL.class)
		// url.openConnection()
		// new ProductWebService();

		// ProductWebService productWebService = new ProductWebService();
		// listProduct = productWebService.getAllProductLight();

		//URL url = new URL(SITEURL + "product/list");
		//Mockito.when(methodCall)
		
//		listProduct = JsonUtils.listProductLightRequest(url);
		
//		conn = (HttpURLConnection) url.openConnection();
//		conn.setConnectTimeout(2000);
//		conn.setReadTimeout(10000);

		listProduct = jsonUtils.listProductLightRequest(conn);

		//URL url = new URL(SITEURL + "product?Lightlist");
		//listProduct = jsonUtils.listProductLightRequest(url);
		
		int i = 0;
		for (ProductLight productLight : listProduct) {
			assertEquals("getAllProductLightTest", listProductExpected.get(i), productLight);
			i++;
		}

	}

}
