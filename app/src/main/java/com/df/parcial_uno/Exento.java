package com.df.parcial_uno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import Models.Producto;

public class Exento extends AppCompatActivity implements View.OnClickListener {

    private Button btnExentoSi;
    private Button btnExentoNo;
    private ListView lvLista;
    private ArrayList<String> listaNoExento = new ArrayList<>();
    private ArrayList<String> listaExento = new ArrayList<>();
    private ArrayList<Producto> prod;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exento);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        prod = bundle.getParcelableArrayList("Productos");
        btnExentoNo = findViewById(R.id.btnExentoNo);
        btnExentoSi = findViewById(R.id.btnExentoSi);
        lvLista = findViewById(R.id.lvLista);

        btnExentoNo.setOnClickListener(this);
        btnExentoSi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnExentoSi){
            String exentoTitulo = "Productos Exentos de IVA: \n";
            String exento = "";
            listaExento.add(exentoTitulo);
            for(Producto prod : prod){
                if (prod.getExento().equals("si"));
                exento = prod.getNombreProducto() + " " + prod.getExento();
                listaExento.add(exento);
            }

            getAdapter(listaExento);
        } else if (v.getId() == R.id.btnExentoNo){
            String noExentoTitulo = "Productos NO Exentos de IVA: \n";
            String noExento = "";
            listaNoExento.add(noExentoTitulo);
            for(Producto prod : prod){
                if (prod.getExento().equals("no"));
                noExento = prod.getNombreProducto() + " " + prod.getExento();
                listaNoExento.add(noExento);
            }

            getAdapter(listaNoExento);
        }
    }
    private void getAdapter(ArrayList<String> list) {
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        lvLista.setAdapter(adapter);
    }
}