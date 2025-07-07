package com.example.listview_y_api_restful;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import android.view.View;
import android.widget.Button;

import WebService.Asynchtask;
import WebService.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    ListView lstOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lstOpciones = findViewById(R.id.lstOpciones);
        Map<String, String> datos = new HashMap<>();
        WebService ws = new WebService("https://fakestoreapi.com/products",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        try {
            JSONArray JSONlistaProductos = new JSONArray(result);
            ArrayList<Productos> lstProducto = Productos.JsonObjectsBuild(JSONlistaProductos);
            ProductAdapter adaptador = new ProductAdapter (this, lstProducto);
            lstOpciones.setAdapter(adaptador);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al procesar los datos JSON de usuarios", Toast.LENGTH_SHORT).show();
        }

    }
}