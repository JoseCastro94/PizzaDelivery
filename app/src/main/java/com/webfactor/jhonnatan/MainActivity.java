package com.webfactor.jhonnatan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtUsuario , txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsuario= findViewById(R.id.lbUsername);
        txtPass= findViewById(R.id.lbPassword);

    }

    public void IniciarSesion(View view){
        String user = txtUsuario.getText().toString();
        String pass = txtPass.getText().toString();
        Toast.makeText(this, "usuario: "+user+", pass: "+pass, Toast.LENGTH_SHORT).show();
    }

    public void IrRegistrarCuenta(View view){
        Intent intent = new Intent(this, MainRegistrarCuenta.class);
        startActivity(intent);
    }

}