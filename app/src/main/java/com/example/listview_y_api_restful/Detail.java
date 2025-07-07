package com.example.listview_y_api_restful;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView detailImage = findViewById(R.id.detailImage);
        TextView detailCategoria = findViewById(R.id.detailCategoria);
        TextView detailPrecio = findViewById(R.id.detailPrecio);
        TextView detailDescripcion = findViewById(R.id.detailDescripcion);

        // Obtener los datos del intent
        String categoria = getIntent().getStringExtra("categoria");
        String precio = getIntent().getStringExtra("precio");
        String descripcion = getIntent().getStringExtra("descripcion");
        String imageUrl = getIntent().getStringExtra("image");

        // Mostrar los datos
        detailCategoria.setText(categoria);
        detailPrecio.setText(precio);
        detailDescripcion.setText(descripcion);

        Glide.with(this)
                .load(imageUrl)
                .into(detailImage);

        Button btnPagar = findViewById(R.id.btnPagar);
        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí se ejecuta el código cuando se hace clic en el botón
                Toast.makeText(Detail.this, "Pagado", Toast.LENGTH_SHORT).show();
            }
        });
    }

}