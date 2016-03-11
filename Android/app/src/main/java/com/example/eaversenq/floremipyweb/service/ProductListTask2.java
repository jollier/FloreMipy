package com.example.eaversenq.floremipyweb.service;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProductListTask2 extends AsyncTask<Void,Void,Void> {

    private final String URL_SERVICE = "http://localhost/Produit/list";
    String resultBack = new String();
    private Handler handler;

    public ProductListTask2(Handler handler) {
        super();
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

            con.setDoOutput(true);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line+"\n");
            }
            br.close();

            resultBack = sb.toString();
            Log.i("depuis handler inBack", resultBack);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    public String getResultBack() {
        return resultBack;
    }

    public void setResultBack(String resultBack) {
        this.resultBack = resultBack;
    }
}