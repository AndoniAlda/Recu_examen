package com.example.dm2.examen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Ejer2 extends AppCompatActivity {
    ListView lview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejer2);
        lview = (ListView) findViewById(R.id.lview);
        String datos[] = {"CIFP Ciudad Jardin LHII","CIFP Mendizorroza LHII","Eraiken CIFP Construccion LHII","Gamarra Ostalaritza Eskola","IES Instituto agrario,Arkaute","IES Mendebaldea"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos);
        lview.setAdapter(adaptador);
    }
}
