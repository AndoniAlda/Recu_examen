package com.example.dm2.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ejer1B extends AppCompatActivity {
    TextView nom;
    TextView dia;
    TextView genero;
    Button acep;
    Button cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejer1_b);
        Bundle extras = getIntent().getExtras();
        nom = (TextView) findViewById(R.id.nombreS);
        dia =(TextView) findViewById(R.id.diaS);
        genero = (TextView) findViewById(R.id.generoS);
        acep = (Button) findViewById(R.id.btnAceptar);
        cancel = (Button) findViewById(R.id.btnCancelar);
        nom.setText(extras.getString("nombre"));
        dia.setText("Has solicitado la consulta el "+extras.getString("dia"));
        genero.setText("con su "+extras.getString("genero"));
        acep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });

    }
}
