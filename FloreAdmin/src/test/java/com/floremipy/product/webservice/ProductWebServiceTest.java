package com.floremipy.product.webservice;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;

import com.floremipy.product.model.ProductLight;
import com.floremipy.product.webservice.ProductWebService;

public class ProductWebServiceTest {

	@Test
	public void getAllProductTest() {
//		ProductWebService productWebService = new ProductWebService();
//		productWebService.getAllProduct();
	}

	@Test
	public void getAllProductLightTest() throws IOException {
		
		ArrayList<ProductLight> listProduct;
		ArrayList<ProductLight> listProductExpected = new ArrayList<ProductLight>();
		
		ProductLight p;
		p = new ProductLight(1L, "Sapin", "Conifère", 5, 1);
		listProductExpected.add(p);
		p = new ProductLight(2L, "Chêne", "Fagacées", 10, 0);
		listProductExpected.add(p);

		InputStream ProductLightJsonExpected = new InputStream() {
			
			@Override
			public int read() throws IOException {
				return 0;
			}
		};
			//ProductLightJsonExpected.read();	

		
		HttpURLConnection connectionWebService = Mockito.mock(HttpURLConnection.class); 
				//new ProductWebService();
		
		Mockito.when(connectionWebService.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
		Mockito.when(connectionWebService.getInputStream()).thenReturn(ProductLightJsonExpected);

		ProductWebService productWebService = new ProductWebService(); 
		listProduct = productWebService.getAllProductLight();
		
		int i = 0;
		for (ProductLight productLight : listProduct) {
			assertEquals("getAllProductLightTest",listProductExpected.get(i), productLight);
			i++;
		}
		
//		"{\"id\":1,\"category\":\"Conifère\",\"description\":\"\",\"name\":\"Sapin\",\"quantityInStock\":5,\"alertLotMature\":1}" +
//		"{\"id\":2,\"category\":\"Fagacées\",\"description\":\"\",\"name\":\"Chêne\",\"quantityInStock\":10,\"alertLotMature\":0}";
//		return 0;
	}

}
