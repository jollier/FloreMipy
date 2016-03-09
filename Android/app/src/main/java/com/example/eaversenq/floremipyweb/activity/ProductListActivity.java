package com.example.eaversenq.floremipyweb.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.eaversenq.floremipyweb.R;
import com.example.eaversenq.floremipyweb.model.Product;
import com.example.eaversenq.floremipyweb.service.ProductService;

import java.util.ArrayList;

public class ProductListActivity  extends Activity {

    private TableLayout table;

    private String strTraitement;
    private ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productlist);

/*        // Handler de communication avec le thread des listes
        Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(final Message msg) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        //strTraitement
                        productList = ProductService.getInstance().fournirListeProduct(strTraitement);
                        displayList();
                    }
                });
                return false;
            }
        });*/

        table = (TableLayout)findViewById(R.id.table);
        productList = ProductService.getInstance().fournirListeProduct(null);
        displayList();


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
        tvName = formatCell("Produit", true);
        tvCategory = formatCell("Catégorie", true);
        tvQuantityInStock = formatCell("Stock", true);
        tvAlertLotMature = formatCell("Retard", true);
        row.addView(tvName);
        row.addView(tvCategory);
        row.addView(tvQuantityInStock);
        row.addView(tvAlertLotMature);
        table.addView(row);

        // Corps de liste
        for (int i = 0 ; i < productList.size(); i++) {

            row = new TableRow(this);
            tvName = formatCell(productList.get(i).getName(), (i % 2 == 1));
            tvCategory = formatCell(productList.get(i).getCategory(), (i % 2 == 1));
            tvQuantityInStock = formatCell(""+productList.get(i).getQuantityInStock(), (i % 2 == 1));
            tvAlertLotMature = formatCell(""+productList.get(i).getAlertLotMature(), (i % 2 == 1));

            row.addView(tvName);
            row.addView(tvCategory);
            row.addView(tvQuantityInStock);
            row.addView(tvAlertLotMature);
            table.addView(row);
        }
    }

    private TextView formatCell(String title, boolean isShadow) {
        TextView result;
        result = new TextView(this);
        result.setText(title);
        result.setTextSize(16);
        result.setGravity(Gravity.LEFT);
        result.setLayoutParams(new TableRow.LayoutParams(10, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        if (isShadow) result.setBackgroundColor(Color.rgb(204, 255, 0));
        return result;
    }
}
