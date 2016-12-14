package com.example.dm2.examen;

import android.content.Intent;
import android.support.annotation.RestrictTo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Ejer1 extends AppCompatActivity {
    EditText nombre;
    RadioGroup rdioGrp;
    RadioButton medico;
    RadioButton enfermera;
    Spinner diasSemana;
    Button solicitar;
    TextView medicosTotal;
    TextView enfermerasTotal;
    int contMedicos;
    int contEnfermeras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejer1);
        contEnfermeras= 0;
        contMedicos = 0;
        nombre = (EditText) findViewById(R.id.etNombre);
        rdioGrp = (RadioGroup) findViewById(R.id.rbGrp);
        medico = (RadioButton) findViewById(R.id.rbMedico);
        enfermera = (RadioButton) findViewById(R.id.rbEnfermera);
        diasSemana = (Spinner) findViewById(R.id.spSemana);
        solicitar = (Button) findViewById(R.id.btnSolicitar);
        medicosTotal = (TextView) findViewById(R.id.tvMedicosTotal);
        enfermerasTotal = (TextView) findViewById(R.id.tvEnfermerasTotal);

        String [] semana = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,semana);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diasSemana.setAdapter(adaptador);
        solicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validar()){
                    Intent intent = new Intent(Ejer1.this, Ejer1B.class);
                    intent.putExtra("nombre",nombre.getText().toString());
                    intent.putExtra("dia",diasSemana.getSelectedItem().toString());
                    if(medico.isChecked()) {
                        intent.putExtra("genero", medico.getText().toString());
                    }else {
                        intent.putExtra("genero", enfermera.getText().toString());
                    }
                    startActivityForResult(intent,1234);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1234 && resultCode==RESULT_OK){
            if(enfermera.isChecked()){
                contEnfermeras++;
                enfermerasTotal.setText("Medico"+contEnfermeras +"");
            }else{
                contMedicos++;
                medicosTotal.setText("Enfermera"+contMedicos+"");
            }
        }else{
            Toast.makeText(Ejer1.this, "La consultaha sido rechaza por el paciente",Toast.LENGTH_SHORT).show();
        }
        nombre.setText("");
        if(enfermera.isChecked()){
            enfermera.setSelected(false);
            medico.setSelected(true);
        }
        String [] semana = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,semana);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diasSemana.setAdapter(adaptador);
    }

    public boolean validar(){
        boolean validado=true;
        if(nombre.getText().toString().equals("")){
            validado = false;
        }
        return validado;
    }
}
