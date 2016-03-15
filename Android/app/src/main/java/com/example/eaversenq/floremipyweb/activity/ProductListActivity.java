package com.example.eaversenq.floremipyweb.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.eaversenq.floremipyweb.R;
import com.example.eaversenq.floremipyweb.model.Product;

import com.example.eaversenq.floremipyweb.service.ProductService;

import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProductListActivity  extends Activity {



    private TableLayout table;

    private ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productlist);

        table = (TableLayout)findViewById(R.id.table);

        // <Récupération des données du web service>

        class GetListProductTask extends AsyncTask<Void, Integer, ArrayList<Product>> {

            //private final String URL_ROOT = "http://localhost:8080/";
            private final String URL_ROOT = "http://blblcar.cloudapp.net/";
            private final String URL_SERVICE = URL_ROOT + "FloreMipy/Product/list";
            private AtomicBoolean isThreadRunnning = new AtomicBoolean();
            private AtomicBoolean isThreadPausing = new AtomicBoolean();

            @Override
            protected void onPreExecute() { }

            @Override
            protected ArrayList<Product> doInBackground(Void... params) {
                ArrayList<Product> result = null;
                try {
                    URL url = new URL(URL_SERVICE);
                    result = ProductService.getInstance().urlFournirListeProduct(url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return result;
            }

            @Override
            protected void onPostExecute(ArrayList<Product> result) {
                productList = result;
                displayList();
            }
        }
        new GetListProductTask().execute();

            // </Récupération des données du web service>

        // NAVIGATION : retour à l'écran d'accueil
        Button btExit = (Button) findViewById(R.id.btExit);
        btExit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdministrationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void displayList() {

        TableRow row;
        TextView tvName;
        TextView tvCategory;
        TextView tvQuantityInStock;
        TextView tvAlertLotMature;

        table.removeAllViews();

        // En-têtes de colonnes
        row = new TableRow(this);
        tvName = formatCell("Produit", 20);
        tvCategory = formatCell("Catégorie", 20);
        tvQuantityInStock = formatCell("Stock", 20);
        tvAlertLotMature = formatCell("Retard", 20);
        row.addView(tvName);
        row.addView(tvCategory);
        row.addView(tvQuantityInStock);
        row.addView(tvAlertLotMature);
        row.setGravity(Gravity.CENTER_VERTICAL);
        row.setBackgroundColor(Color.rgb(238, 255, 204));
        row.setMinimumHeight(50);
        table.addView(row);

        // Corps de liste
        for (int i = 0 ; i < productList.size(); i++) {

            row = new TableRow(this);
            tvName = formatCell(productList.get(i).getName(), 16);
            tvCategory = formatCell(productList.get(i).getCategory(), 16);
            tvQuantityInStock = formatCell(""+productList.get(i).getQuantityInStock(), 16);
            tvAlertLotMature = formatCell(""+productList.get(i).getAlertLotMature(), 16);

            row.addView(tvName);
            row.addView(tvCategory);
            row.addView(tvQuantityInStock);
            row.addView(tvAlertLotMature);
            row.setGravity(Gravity.CENTER_VERTICAL);
            if (i % 2 == 1) row.setBackgroundColor(Color.rgb(238, 255, 204));
            row.setMinimumHeight(50);

            final long id = productList.get(i).getId();
            row.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), ProductActivity.class);
                    //intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    Log.i("Manolo", "Send " + id);
                    int requestCode = (int)id;
                    intent.putExtra("requestCode", requestCode);
                    startActivityForResult(intent, requestCode);
                }
            });

            table.addView(row);
        }
    }

    private TextView formatCell(String title, int size) {
        TextView result;
        result = new TextView(this);
        result.setText(title);
        result.setTextSize(size);
        result.setGravity(Gravity.LEFT);
        result.setLayoutParams(new TableRow.LayoutParams(10, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        return result;
    }
}
