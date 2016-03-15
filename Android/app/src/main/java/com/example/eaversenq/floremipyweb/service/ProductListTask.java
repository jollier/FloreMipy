package com.example.eaversenq.floremipyweb.service;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import com.example.eaversenq.floremipyweb.model.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ProductListTask extends AsyncTask<Void,Void,Void> {

    private final String URL_SERVICE = "http://localhost:8080/FloreMipy/Product/list";
    ArrayList<Product> resultBack;
    private Handler handler;

    public ProductListTask(Handler handler) {
        this.handler = handler;
    }

    protected void onPreExecute() {}

    protected void onPostExecute(Void result) {
        Message message = new Message();
        handler.sendMessage(message);
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            URL url = new URL(URL_SERVICE);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.connect();

            if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
                return null;
            }

            InputStream is = con.getInputStream();
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;

            while ((inputStr = streamReader.readLine()) != null) responseStrBuilder.append(inputStr);
            Type listType = new TypeToken<ArrayList<Product>>() {
            }.getType();
            resultBack = new Gson().fromJson(responseStrBuilder.toString(), listType);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Product> getResultBack() {
        return resultBack;
    }

    public void setResultBack(ArrayList<Product> resultBack) {
        this.resultBack = resultBack;
    }
}
