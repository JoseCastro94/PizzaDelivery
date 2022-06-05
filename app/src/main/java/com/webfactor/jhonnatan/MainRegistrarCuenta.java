package com.webfactor.jhonnatan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainRegistrarCuenta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cuenta);
    }

    public void IrInicioSesion(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}