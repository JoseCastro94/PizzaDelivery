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
import com.webfactor.jhonnatan.dao.PizzaDAO;
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
        PizzaDAO dao = new PizzaDAO(getContext());
        Pizza obj = new Pizza();
        obj.setNombre(txtNombre.getText().toString());
        obj.setPrecio(Double.parseDouble(txtPrecio.getText().toString()));
        obj.setStock(Integer.parseInt(txtStock.getText().toString()));
        obj.setImagen(getImagenAzar());
        if(dao.Insertar(obj) > 0){
            Toast.makeText(getContext(),"Pizza Registrada correctamente!!",Toast.LENGTH_LONG).show();
            LimpiarCasillas();
        }else{
            Toast.makeText(getContext(),"Lo sentimos!! No se ha podido registrar pizza." ,Toast.LENGTH_LONG).show();
        }
    }
    public void LimpiarCasillas(){
        txtNombre.setText(null);
        txtPrecio.setText(null);
        txtStock.setText(null);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnGuardar:
                GuardarPizza();
                break;
        }
    }

    public String getImagenAzar(){
        String imagenes[] = {
                "https://www.recetasdesbieta.com/wp-content/uploads/2018/09/Como-hacer-pizza-casera-rapida-con-masa-de-pizza-sin-repos-1.jpg",
                "https://dcom-prod.imgix.net/files/wp-content/uploads/2016/06/1465586619-Pizzas-exoticas.jpg?w=1280&h=720&crop=focalpoint&fp-x=0.5&fp-y=0.1&fit=crop&auto=compress&q=75",
                "https://static-sevilla.abc.es/media/gurmesevilla/2013/04/pizza-margarita.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnIr_u1Y4pza-fi234je3CIlvOFof5JB6xZ2T8C61mt_A32Kl_z4upDi8vWLJSqC8QQD4&usqp=CAU",
                "https://www.sabervivirtv.com/medio/2018/07/23/8pizzafibrayvitaminas_76671d24.jpg",
                "https://static.misionesonline.news/wp-content/uploads/2017/05/FreeGreatPicture.com-14713-hd-pizza-gourmet-1024x640-2srve2s1qd1g.jpeg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSH2dVjEyZ-EXT8ZWj9yxleklL_IG8T6neROCNIfmZseQQTX1O2Px0N3w6P3pjI2Yirqt0&usqp=CAU",
                "https://images.aws.nestle.recipes/original/19b7487f2077449a98dc57687adaec00_pizza_con_tofu.jpeg"
        };

        int fin = imagenes.length;

        int azar = (int)(Math.random() * fin);
        return imagenes[azar];
    }

}