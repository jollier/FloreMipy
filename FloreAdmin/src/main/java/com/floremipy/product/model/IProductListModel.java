package com.floremipy.product.model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.google.gson.JsonSyntaxException;

public interface IProductListModel {

	ArrayList<ProductLight> getListProduct() throws JsonSyntaxException, MalformedURLException, UnsupportedEncodingException, IOException;

}