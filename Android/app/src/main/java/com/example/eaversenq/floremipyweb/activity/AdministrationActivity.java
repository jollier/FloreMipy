package com.example.eaversenq.floremipyweb.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.eaversenq.floremipyweb.R;
import com.example.eaversenq.floremipyweb.model.Cnx;

/**
 * Created by EAVERSENQ on 01/03/2016.
 */
public class AdministrationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administration);

        ((EditText)findViewById(R.id.txUser)).setText(Cnx.getInstance().getPrenom() + " " + Cnx.getInstance().getNom());
    }
}
