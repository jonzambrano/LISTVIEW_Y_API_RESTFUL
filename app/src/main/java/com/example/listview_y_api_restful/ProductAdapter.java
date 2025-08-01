package com.example.listview_y_api_restful;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Productos> {
    public ProductAdapter(Context context, ArrayList<Productos> datos) {
        super(context, R.layout.product_item, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.product_item, null);

        TextView txtCategoria = item.findViewById(R.id.lblCategoria);
        txtCategoria.setText(getItem(position).getCategoria());

        TextView txtPrecio = item.findViewById(R.id.lblPrecio);
        txtPrecio.setText(getItem(position).getPrecio());

        TextView txtDescripcion = item.findViewById(R.id.lblDescripcion);
        txtDescripcion.setText(getItem(position).getDescription());

        ImageView imageView = item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext())
                .load(getItem(position).getImage())
                .into(imageView);


        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Detail.class);
                intent.putExtra("categoria", getItem(position).getCategoria());
                intent.putExtra("precio", getItem(position).getPrecio());
                intent.putExtra("descripcion", getItem(position).getDescription());
                intent.putExtra("image", getItem(position).getImage());
                getContext().startActivity(intent);
            }
        });

        return item;
    }
}