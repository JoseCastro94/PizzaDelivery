package com.webfactor.jhonnatan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.webfactor.jhonnatan.dao.ConexionSQLiteHelper;
import com.webfactor.jhonnatan.dao.UsuarioDAO;
import com.webfactor.jhonnatan.model.Usuario;
import com.webfactor.jhonnatan.view.ContainerActivity;

public class MainActivity extends AppCompatActivity {
    EditText txtUsuario , txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsuario=(EditText) findViewById(R.id.lbUsername);
        txtPass=(EditText) findViewById(R.id.lbPassword);

        txtUsuario.setText("admin");
        txtPass.setText("123456");
    }

    public void IniciarSesion(View view){
        UsuarioDAO dao = new UsuarioDAO(getApplication());
        String user = txtUsuario.getText().toString();
        String pass = txtPass.getText().toString();

        if(user.length() == 0 || pass.length() == 0){
            Toast.makeText(this, "Los campos son requeridos."+pass, Toast.LENGTH_SHORT).show();
        }else{
            Usuario obj = dao.Consultar(user,pass);

            if(obj == null){
                Toast.makeText(this, "Usuario y/o contraseña incorrecto.", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Bienvenido. ", Toast.LENGTH_SHORT).show();
                IrAInicio();
            }
        }
     }

    public void IrRegistrarCuenta(View view){
        Intent intent = new Intent(this, MainRegistrarCuenta.class);
        startActivity(intent);
    }

    public void IrAInicio(){
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }

}