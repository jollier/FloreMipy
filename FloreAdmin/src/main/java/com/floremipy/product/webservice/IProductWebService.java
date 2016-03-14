package com.floremipy.product.webservice;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.floremipy.product.model.ProductLight;


public interface IProductWebService {

	ArrayList<ProductLight> getAllProductLight() throws  MalformedURLException, UnsupportedEncodingException, IOException;

}