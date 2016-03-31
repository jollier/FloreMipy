package com.floremipy.product.webservice;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.apache.commons.codec.binary.Base64;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.stereotype.Component;

import com.floremipy.product.model.Product;
import com.floremipy.product.model.ProductLight;
import com.floremipy.product.model.ProductLightTableModel;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

@Component
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
			throws IOException, UnsupportedEncodingException, JsonSyntaxException {
		ArrayList<ProductLight> response;
		this.conn = conn;

		// *************** Stub HttpURLConnection **************
		//		MockitoAnnotations.initMocks(this);
		//		this.conn = Mockito.mock(HttpURLConnection.class);
		//		String jsonExpected = "[{\"id\":1,\"category\":\"Conifère\",\"description\":\"\",\"name\":\"Sapin\",\"quantityInStock\":5,\"alertLotMature\":1},"
		//				+ "{\"id\":2,\"category\":\"Fagacées\",\"description\":\"\",\"name\":\"Chêne\",\"quantityInStock\":10,\"alertLotMature\":0}]";
		//		InputStream ProductLightJsonExpected = null;
		//
		//		ProductLightJsonExpected = new ByteArrayInputStream(jsonExpected.getBytes("UTF-8"));
		//
		//		Mockito.when(this.conn.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
		//		Mockito.when(this.conn.getInputStream()).thenReturn(ProductLightJsonExpected);
		//		
		// *************** Fin du Stub **************

		this.conn.connect();

		// expect HTTP 200 OK, so we don't mistakenly save error report
		// instead of the file
		if (this.conn.getResponseCode() != HttpURLConnection.HTTP_OK) {

			response = null; 
			// "Server returned HTTP " +
			// connection.getResponseCode() + " " +
			// connection.getResponseMessage();
		} else {

			response = convertJSonToListProductLight(readWebStream());
		}

		return response;
	}

	public Product productReadRequest(HttpURLConnection conn)
			throws IOException, UnsupportedEncodingException, JsonSyntaxException {
		Product response;
		this.conn = conn;

		// *************** Stub HttpURLConnection **************
		//		MockitoAnnotations.initMocks(this);
		//		this.conn = Mockito.mock(HttpURLConnection.class);
		//		String jsonExpected = "{\"id\":1,\"category\":\"Conifère\",\"description\":\"\",\"name\":\"Sapin\",\"quantityInStock\":5,\"alertLotMature\":1}";
		//		InputStream productJsonExpected = null;
		//
		//		productJsonExpected = new ByteArrayInputStream(jsonExpected.getBytes("UTF-8"));
		//
		//		Mockito.when(this.conn.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
		//		Mockito.when(this.conn.getInputStream()).thenReturn(productJsonExpected);
		//		
		// *************** Fin du Stub **************

		this.conn.connect();

		// expect HTTP 200 OK, so we don't mistakenly save error report
		// instead of the file
		if (this.conn.getResponseCode() != HttpURLConnection.HTTP_OK) {

			response = null; 
			// "Server returned HTTP " +
			// connection.getResponseCode() + " " +
			// connection.getResponseMessage();
		} else {

			response = convertJSonToProduct(readWebStream());
		}

		return response;
	}

	private String readWebStream() throws IOException, UnsupportedEncodingException {
		String responseStr;
		InputStream is = this.conn.getInputStream();

		BufferedReader streamReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		StringBuilder responseStrBuilder = new StringBuilder();

		String inputStr;
		while ((inputStr = streamReader.readLine()) != null)
			responseStrBuilder.append(inputStr);

		responseStr = responseStrBuilder.toString();
		return responseStr;
	}

	private byte[] readWebBytesStream() throws IOException {
		byte[] encodedBytes;
		byte[] decodedBytes;
		String responseStr;
		int tailleDonnees = this.conn.getContentLength();
		InputStream is = this.conn.getInputStream();
		StringBuilder responseStrBuilder = new StringBuilder();

		BufferedReader streamReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		int inputStr;
		while ((inputStr = streamReader.read()) != -1)
			responseStrBuilder.append(inputStr);

		responseStr = responseStrBuilder.toString();
		encodedBytes = responseStr.getBytes(StandardCharsets.UTF_8);
		decodedBytes = Base64.decodeBase64(encodedBytes);
		return decodedBytes;
	}

	private ArrayList<ProductLight> convertJSonToListProductLight(String responseStr) {
		ArrayList<ProductLight> response;
		Type listType = new TypeToken<ArrayList<ProductLight>>() {
		}.getType();
		response = new Gson().fromJson(responseStr, listType);
		return response;
	}

	private Product convertJSonToProduct(String responseStr) {
		Product response;
		response = new Gson().fromJson(responseStr, Product.class);
		return response;
	}

	private String convertProductToJSon(Product product) {
		String response;
		response = new Gson().toJson(product, Product.class);
		return response;
	}

	public HttpURLConnection getConnexion(URL url) throws IOException {
		HttpURLConnection conn;
		conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(2000);
		conn.setReadTimeout(10000);
		return conn;
	}

	public boolean productCreateRequest(HttpURLConnection conn, Product product) throws IOException {
		this.conn = conn;
		boolean response = false;
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		this.conn.connect();

		OutputStream os = conn.getOutputStream();
		os.write(convertProductToJSon(product).getBytes());
		os.flush();

		if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();

		return response;
	}

	public boolean productUpdateRequest(HttpURLConnection conn, Product product) throws IOException {
		this.conn = conn;
		boolean response = false;
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		this.conn.connect();

		OutputStream os = conn.getOutputStream();
		os.write(convertProductToJSon(product).getBytes());
		os.flush();

		if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();

		return response;
	}

	public Image getImageProductRequest(URL url) throws IOException {
		Image image = null;
		image = ImageIO.read(url);
		return image;
	}
}
