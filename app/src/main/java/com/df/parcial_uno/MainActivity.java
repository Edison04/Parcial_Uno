package com.df.parcial_uno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Models.Producto;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText codigo;
    private EditText nombreProducto;
    private EditText valor;
    private EditText exento;
    private EditText categoria;
    private EditText descripcion;
    private Button btnAgregar;
    private Button btnExento;
    private Button btnMasCostoso;
    private Button btnMenosCostoso;
    private ListView respuesta;
    public ArrayList<Producto> listaProducto = new ArrayList<Producto>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        codigo = findViewById(R.id.txtCodigo);
        nombreProducto = findViewById(R.id.txtProducto);
        valor = findViewById(R.id.txtValor);
        exento = findViewById(R.id.txtExento);
        categoria = findViewById(R.id.txtCategoria);
        descripcion = findViewById(R.id.txtDescripcion);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnExento = findViewById(R.id.btnExento);
        btnMasCostoso = findViewById(R.id.btnMasCostosos);
        btnMenosCostoso = findViewById(R.id.btnMenosCostoso);
        respuesta = findViewById(R.id.lvRespuesta);

        btnAgregar.setOnClickListener(this);
        btnExento.setOnClickListener(this);
        btnMenosCostoso.setOnClickListener(this);
        btnMasCostoso.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregar) {
            agregarProducto();
            limpiarTexto();
        } else if (v.getId() == R.id.btnMasCostosos) {
            ordenarListaProducto();
            Collections.reverse(listaProducto);
            ArrayList<String> masCostoso = new ArrayList<>();
            String masCosto = "10 Productos más costosos: \n";
            for (int i = 0; i < listaProducto.size(); i++){
                if (!listaProducto.get(i).toString().isEmpty()) {
                    masCosto = listaProducto.get(i).getNombreProducto() + ": " +listaProducto.get(i).getValor();
                    masCostoso.add(masCosto);
                }
            }
            getAdapter(masCostoso);
        } else if (v.getId() == R.id.btnMenosCostoso) {
            ordenarListaProducto();
            ArrayList<String> menosCostoso = new ArrayList<>();
            String menosCosto = "10 Productos más costosos: \n";
            for (int i = 0; i < listaProducto.size(); i++){
                if (!listaProducto.get(i).toString().isEmpty()) {
                    menosCosto = listaProducto.get(i).getNombreProducto() + ": " + listaProducto.get(i).getValor();
                    menosCostoso.add(menosCosto);
                }
            }
            getAdapter(menosCostoso);
        } else if (v.getId() == R.id.btnExento) {
            Intent myIntent = new Intent(this, Exento.class);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("Productos", listaProducto);
            myIntent.putExtras(bundle);
            startActivity(myIntent);
        }
    }

    private void getAdapter(ArrayList<String> list) {
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        respuesta.setAdapter(adapter);
    }
    private void ordenarListaProducto() {
        Collections.sort(listaProducto, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                return new Double(o1.getValor()).compareTo(new Double(o2.getValor()));
            }
        });
    }

    private void limpiarTexto(){
        codigo.setText("");
        nombreProducto.setText("");
        valor.setText("");
        exento.setText("");
        categoria.setText("");
        descripcion.setText("");
    }

    private void agregarProducto(){
        String _codigo = codigo.getText().toString();
        String _nombreProducto = nombreProducto.getText().toString();
        double _valor = Double.parseDouble(valor.getText().toString());
        String _exento = exento.getText().toString().toLowerCase();
        String _categoria = categoria.getText().toString();
        String _descripcion = descripcion.getText().toString();

        Producto producto = new Producto(_codigo, _nombreProducto, _valor, _exento, _categoria, _descripcion);
        listaProducto.add(producto);
    }
}