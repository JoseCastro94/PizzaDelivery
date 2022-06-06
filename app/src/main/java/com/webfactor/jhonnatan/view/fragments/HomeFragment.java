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
import com.webfactor.jhonnatan.dao.PizzaDAO;
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

    public ArrayList<Pizza> buildPictures(){
        PizzaDAO dao = new PizzaDAO(getContext());
        return dao.listado();
    }
}