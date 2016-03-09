package com.example.eaversenq.floremipyweb.service;

import android.util.Log;

import com.example.eaversenq.floremipyweb.model.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductService {

    private static ProductService p;

    private ProductService() {}

    public static ProductService getInstance() {
        if (p == null) p = new ProductService();
        return p;
    }

    public ArrayList<Product> fournirListeProduct(String strJson) {
        return defaultFournirListeProduct();
    }

    public ArrayList<Product> jsonFournirListeProduct(String strJson) {
        ArrayList<Product> result = new ArrayList<Product>();
        Product product;

        try {
            JSONArray jArray = new JSONArray(strJson);
            for(int i=0;i<jArray.length();i++){
                JSONObject json_data = jArray.getJSONObject(i);
                product = new Product(json_data.getLong("id"), json_data.getString("name").toUpperCase(), json_data.getString("category"), json_data.getInt("quantityInStock"),  json_data.getInt("alertLotMature"));
                result.add(product);
            }
        } catch(JSONException e) {
            Log.e("log_tag", "Error parsing data " + e.toString());
        }
        return result;
    }

    private ArrayList<Product> defaultFournirListeProduct() {
        ArrayList<Product> result = new ArrayList<Product>();

        Log.i("List", "Le service « fournirListeProduct » n'a retourné aucun produit");
        result.add(new Product(1, "Cèdre du Liban", "Arbre", 4, 0));
        result.add(new Product(1, "Hêtre", "Arbre", 1, 3));
        result.add(new Product(1, "Asparagus", "Plante d'intérieur", 9, 0));

        return result;
    }
}
