package com.webfactor.jhonnatan.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webfactor.jhonnatan.R;
import com.webfactor.jhonnatan.adapter.PizzaAdapterRecyclerView;
import com.webfactor.jhonnatan.model.Pizza;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView pictureRecycler = (RecyclerView) view.findViewById(R.id.pictureRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        pictureRecycler.setLayoutManager(linearLayoutManager);
        PizzaAdapterRecyclerView pictureAdapterRecyclerView = new PizzaAdapterRecyclerView( buildPictures(), R.layout.card_view_pizza, getActivity());
        pictureRecycler.setAdapter(pictureAdapterRecyclerView);

        return view;
    }

    public ArrayList<Pizza> buildPictures() {
        ArrayList<Pizza> pictures = new ArrayList<>();

        pictures.add(new Pizza(1,"https://content.r9cdn.net/rimg/dimg/da/f2/e698eeb7-city-1955-164dcef375f.jpg",
                "Uriel Ramírez", 12, 3));
        pictures.add(new Pizza(2,"https://www.eurocasa.com/media/tuscany-tips/5711-A.jpg",
                "Juan Pablo", 23, 55));
        pictures.add(new Pizza(3,"http://www.educationquizzes.com/library/KS3-Geography/river-1-1.jpg",
                "Anahi Salgado",44, 45));

        return pictures;

    }
}