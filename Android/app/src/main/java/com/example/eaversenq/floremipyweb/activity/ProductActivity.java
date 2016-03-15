package com.example.eaversenq.floremipyweb.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.eaversenq.floremipyweb.R;
import com.example.eaversenq.floremipyweb.model.Product;
import com.example.eaversenq.floremipyweb.service.ConnexionService;
import com.example.eaversenq.floremipyweb.service.ProductService;

import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProductActivity extends Activity {

    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        TextView tvTitle = (TextView)findViewById(R.id.tvTitle);
        tvTitle.setText("Produit n° : " + ConnexionService.getInstance().getCtx().getProductId());

        // <Récupération des données du web service>

        class GetProductTask extends AsyncTask<Void, Integer, Product> {

            private final String URL_ROOT = "http://blblcar.cloudapp.net/";
            private final String URL_SERVICE = URL_ROOT + "FloreMipy/Product?id=" + ConnexionService.getInstance().getCtx().getProductId();
            private AtomicBoolean isThreadRunnning = new AtomicBoolean();
            private AtomicBoolean isThreadPausing = new AtomicBoolean();

            @Override
            protected void onPreExecute() { }

            @Override
            protected Product doInBackground(Void... params) {
                Product result = null;
                try {
                    URL url = new URL(URL_SERVICE);
                    result = ProductService.getInstance().urlFournirProduct(url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return result;
            }

            @Override
            protected void onPostExecute(Product result) {
                product = result;
            }

        }

        // </Récupération des données du web service>
    }
}
