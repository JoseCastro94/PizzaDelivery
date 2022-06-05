package com.webfactor.jhonnatan.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.webfactor.jhonnatan.R;
import com.webfactor.jhonnatan.model.Pizza;

public class RegistroPizzaFragment extends Fragment implements View.OnClickListener {
    EditText txtPrecio, txtStock , txtNombre ;
    Button btnGuardar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro_pizza, container, false);
        txtPrecio= (EditText) view.findViewById(R.id.lbRPrecio);
        txtStock= (EditText) view.findViewById(R.id.lbRStock);
        txtNombre= (EditText) view.findViewById(R.id.lbRNombrePizza);
        btnGuardar = (Button) view.findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(this);
        return view;
    }

    public void GuardarPizza(){
        Pizza obj = new Pizza();
        obj.setNombre(txtNombre.getText().toString());
        obj.setPrecio(Double.parseDouble(txtPrecio.getText().toString()));
        obj.setStock(Integer.parseInt(txtStock.getText().toString()));
        obj.setImagen("https://placeralplato.com/files/2016/05/Pizza-crocante-640x480.jpg");
       Toast.makeText(getContext(),"Pizza Registrada correctamente!!: "+obj.toString() ,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnGuardar:
                GuardarPizza();
                break;
        }
    }
}