package com.example.eaversenq.floremipyweb.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eaversenq.floremipyweb.R;

public class ConnexionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        // NAVIGATION : accès à l'écran d'administration
        Button btOk = (Button)findViewById(R.id.btOk);
        btOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AdministrationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivityForResult(intent, 0);
            }
        });

        // NAVIGATION : exit
        Button btCancel = (Button)findViewById(R.id.btCancel);
        btCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
}
