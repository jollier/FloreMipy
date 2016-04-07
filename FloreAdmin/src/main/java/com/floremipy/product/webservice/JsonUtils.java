package com.floremipy.product.webservice;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import com.floremipy.product.model.Product;
import com.floremipy.product.model.ProductLight;
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

	public boolean productDeleteRequest(HttpURLConnection conn) throws IOException {
		this.conn = conn;
		boolean response = false;
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");

		this.conn.connect();

		// expect HTTP 200 OK, so we don't mistakenly save error report
		// instead of the file
		if (this.conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
 
			// "Server returned HTTP " +
			// connection.getResponseCode() + " " +
			// connection.getResponseMessage();
		} else {

			response = true;
		}

		return response;
	}
	
	public Image getImageProductRequest(URL url) throws IOException {
		Image image = null;
		image = ImageIO.read(url);
		return image;
	}
	
	public boolean productImageUpdatePost(HttpURLConnection conn, String imageFile) throws IOException {
		// http://stackoverflow.com/questions/24890675/file-upload-using-rest-api-in-java
		String charset = "UTF-8";
		String CRLF = "\r\n";
		String boundary = Long.toHexString(System.currentTimeMillis());
		File binaryFile = new File(imageFile);
		this.conn = conn;
		boolean response = false;
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setConnectTimeout(10000);
		conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
		try (	OutputStream output = conn.getOutputStream();
			    PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, charset), true);
				)
		{
			writer.append("--" + boundary).append(CRLF);
			writer.append("Content-Disposition: form-data; name=\"" + binaryFile.getName() + "\"; file=\"" + binaryFile.getName() + "\"").append(CRLF);
		    writer.append("Content-Type: " + URLConnection.guessContentTypeFromName(binaryFile.getName())).append(CRLF);
		    writer.append("Content-Transfer-Encoding: binary").append(CRLF);
		    writer.append(CRLF).flush();
		    Files.copy(binaryFile.toPath(), output);
		    output.flush(); // Important before continuing with writer!
		    writer.append(CRLF).flush(); // CRLF is important! It indicates end of boundary.

		    // End of multipart/form-data.
		    writer.append("--" + boundary + "--").append(CRLF).flush();
		}
		
		int responseCode = ((HttpURLConnection) conn).getResponseCode();
		System.out.println(responseCode); // Should be 200
		return (responseCode == 200);
		
	}
}
