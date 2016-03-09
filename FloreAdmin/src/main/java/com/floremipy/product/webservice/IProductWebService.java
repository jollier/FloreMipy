package com.floremipy.product.webservice;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.floremipy.product.model.ProductLight;


public interface IProductWebService {

	ArrayList<ProductLight> getAllProductLight();

}