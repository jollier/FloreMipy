package com.example.eaversenq.floremipyweb.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.eaversenq.floremipyweb.R;

public class ProductActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("Manolo", "doInBackground");
        TextView tvTitle = (TextView)findViewById(R.id.tvTitle);
        tvTitle.setText("Produit n° : " + requestCode);
    }
}
