package com.webfactor.jhonnatan.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.webfactor.jhonnatan.R;
import com.webfactor.jhonnatan.dao.PizzaDAO;
import com.webfactor.jhonnatan.model.Pizza;

public class ModificarPizzaFragment extends Fragment  implements View.OnClickListener {
    EditText txtPrecio, txtStock , txtNombre,txtCodigo ;
    Button btnModificar ,btnConsultar, btnEliminar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_modificar_pizza, container, false);
        txtCodigo= (EditText) view.findViewById(R.id.lbRCodigoModif);
        txtPrecio= (EditText) view.findViewById(R.id.lbRPrecioModif);
        txtStock= (EditText) view.findViewById(R.id.lbRStockModif);
        txtNombre= (EditText) view.findViewById(R.id.lbRNombrePizzaModif);
        btnConsultar = (Button) view.findViewById(R.id.btnConsultar);
        btnModificar = (Button) view.findViewById(R.id.btnModificar);
        btnEliminar = (Button) view.findViewById(R.id.btnEliminar);
        btnConsultar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnModificar.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnConsultar:
                Consultar();
                break;
            case R.id.btnEliminar:
                eliminar();
                break;
            case R.id.btnModificar:
                modificar();
                break;
        }
    }

    public void modificar(){
        try{
            PizzaDAO dao = new PizzaDAO(getContext());
            Pizza obj = new Pizza();

            obj.setCodPizza(Integer.parseInt(txtCodigo.getText().toString()));
            obj.setNombre(txtNombre.getText().toString());
            obj.setPrecio(Double.parseDouble(txtPrecio.getText().toString()));
            obj.setStock(Integer.parseInt(txtStock.getText().toString()));

            if(dao.Modificar(obj) > 0){
                Toast.makeText(getContext(),"Pizza modificada correctamente!!",Toast.LENGTH_LONG).show();
                LimpiarCasillas();
            }else{
                Toast.makeText(getContext(),"Lo sentimos!! No se ha podido modificar datos de la pizza." ,Toast.LENGTH_LONG).show();
            }
        }catch(Exception ex){
           Toast.makeText(getContext(),"Lo sentimos!! Por favor verifique que todos los datos sean correcto." ,Toast.LENGTH_LONG).show();
         }
    }

    public void Consultar(){
       try{
           PizzaDAO dao = new PizzaDAO(getContext());
           int code = Integer.parseInt(txtCodigo.getText().toString());

           Pizza obj = dao.Consulta(code);

           if(obj != null){
               txtCodigo.setText(""+obj.getCodPizza());
               txtPrecio.setText(""+obj.getPrecio());
               txtStock.setText(""+obj.getStock());
               txtNombre.setText(""+obj.getNombre());
           }else{
               LimpiarCasillas();
               Toast.makeText(getContext(),"Lo sentimos!! La pizza con codigo "+code+" no existe." ,Toast.LENGTH_LONG).show();
           }

       }catch(Exception ex){
           Toast.makeText(getContext(),"Lo sentimos!! Por favor verifique que todos los datos sean correcto." ,Toast.LENGTH_LONG).show();

       }
    }

    public void eliminar(){
        try{
            PizzaDAO dao = new PizzaDAO(getContext());
            int code = Integer.parseInt(txtCodigo.getText().toString());

            Pizza obj = dao.Consulta(code);

            if(obj != null){
                if(dao.Eliminar(code) > 0){
                    Toast.makeText(getContext(),"La pizza se elimino correctamente." ,Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getContext(),"Lo sentimos!! La pizza no se ha podido eliminar." ,Toast.LENGTH_LONG).show();

                }
            }else{
                LimpiarCasillas();
                Toast.makeText(getContext(),"Lo sentimos!! La pizza con codigo "+code+" no existe." ,Toast.LENGTH_LONG).show();
            }

        }catch(Exception ex){
            Toast.makeText(getContext(),"Lo sentimos!! Los datos son incorrecto." ,Toast.LENGTH_LONG).show();
        }
    }

    public void LimpiarCasillas(){
        txtNombre.setText(null);
        txtPrecio.setText(null);
        txtStock.setText(null);
    }
}