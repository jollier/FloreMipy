package com.example.eaversenq.floremipyweb.service;

import com.example.eaversenq.floremipyweb.model.Product;

import java.util.ArrayList;

public class ProductService {

    private ProductService p;

    private ProductService() {}

    public ProductService getInstance() {
        if (p == null) p = new ProductService();
        return p;
    }

    public ArrayList<Product> fournirListeProduct(String strJson) {
        ArrayList<Product> result = new ArrayList<Product>();
        return result;
    }
}
