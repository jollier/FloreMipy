package com.example.eaversenq.floremipyweb.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.eaversenq.floremipyweb.R;
import com.example.eaversenq.floremipyweb.model.Connexion;
import com.example.eaversenq.floremipyweb.service.ConnexionService;

public class AdministrationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administration);

        ((EditText)findViewById(R.id.txUser)).setText("Bienvenu(e) " + ConnexionService.getInstance().getCnx().getPrenom() + " " + ConnexionService.getInstance().getCnx().getNom());

        // NAVIGATION : accès à l'écran de la liste des produits
        Button btProduit = (Button)findViewById(R.id.btProduit);
        btProduit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ProductListActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivityForResult(intent, 0);
            }
        });

        // NAVIGATION : exit
        Button btExit = (Button)findViewById(R.id.btExit);
        btExit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                System.exit(0);
            }
        });

    }
}
