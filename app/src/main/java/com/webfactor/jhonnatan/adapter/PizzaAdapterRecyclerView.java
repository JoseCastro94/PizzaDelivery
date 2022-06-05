package com.webfactor.jhonnatan.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.webfactor.jhonnatan.R;
import com.webfactor.jhonnatan.model.Pizza;

import java.util.ArrayList;

public class PizzaAdapterRecyclerView extends RecyclerView.Adapter<PizzaAdapterRecyclerView.PictureViewHolder>   {

    private ArrayList<Pizza> pictures;
    private int resource;
    private Activity activity;

    public PizzaAdapterRecyclerView(ArrayList<Pizza> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent , false);

        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder holder, int position) {
        Pizza picture = pictures.get(position);
        holder.nombreCard.setText(picture.getNombre());
        holder.precioCard.setText(""+picture.getPrecio());
        holder.stockCard.setText(""+picture.getStock());
        Picasso.get().load(picture.getImagen()).into(holder.imagenCard);
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagenCard;
        private TextView nombreCard;
        private TextView precioCard;
        private TextView stockCard;

        public PictureViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenCard = (ImageView) itemView.findViewById(R.id.imagenCard);
            nombreCard = (TextView) itemView.findViewById(R.id.nombreCard);
            precioCard = (TextView) itemView.findViewById(R.id.PrecioCard);
            stockCard = (TextView) itemView.findViewById(R.id.StockCard);
        }
    }
}
