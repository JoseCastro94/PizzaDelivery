package com.webfactor.jhonnatan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.webfactor.jhonnatan.dao.ConexionSQLiteHelper;
import com.webfactor.jhonnatan.dao.UsuarioDAO;
import com.webfactor.jhonnatan.model.Usuario;

public class MainRegistrarCuenta extends AppCompatActivity {
    EditText txtUsuario , txtPass , txtConfPass , txtCorreo , txtNombres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cuenta);
        txtUsuario=(EditText) findViewById(R.id.lbRUsername);
        txtPass=(EditText) findViewById(R.id.lbRPassword);
        txtConfPass=(EditText) findViewById(R.id.lbRConfirmarPassword);
        txtCorreo=(EditText) findViewById(R.id.lbRCorreo);
        txtNombres=(EditText) findViewById(R.id.lbRNombre);
    }
    public void RegistrarCuenta(View view){
        UsuarioDAO dao = new UsuarioDAO(getApplication());
        String confirm = txtConfPass.getText().toString();
        Usuario obj = new Usuario();
        obj.setNombre(txtNombres.getText().toString());
        obj.setUsername(txtUsuario.getText().toString());
        obj.setCorreo(txtCorreo.getText().toString());
        obj.setContrasennia(txtPass.getText().toString());

        if(obj.getNombre().length() == 0 ||
                obj.getUsername().length() == 0 ||
                obj.getContrasennia().length() == 0 ||
                obj.getCorreo().length() == 0 ||
                confirm.length() == 0
        ){
            Toast.makeText(this, "Todos los campos son requeridos.!",
                    Toast.LENGTH_LONG).show();
        }else{
            if(obj.getContrasennia().equals(confirm)){
                if(dao.ExisteUsuario(obj.getUsername()) == 0){
                    if(dao.Insertar(obj) > 0){
                        Toast.makeText(this, "Usuario registrado correctamente!",
                                Toast.LENGTH_LONG).show();
                        LimpiarCasillas();
                    }else{
                        Toast.makeText(this, "Lo sentimos!! No se ha podido registrar usuario.",
                                Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(this, "Lo sentimos!! El usuario "+obj.getUsername()+" ya se encuentra registrado",
                            Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(this, "Las contraseñas no coinciden.",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    public void LimpiarCasillas(){
        txtUsuario.setText(null);
        txtNombres.setText(null);
        txtConfPass.setText(null);
        txtCorreo.setText(null);
        txtPass.setText(null);
    }

    public void IrInicioSesion(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}