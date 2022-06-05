package com.webfactor.jhonnatan.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.webfactor.jhonnatan.utils.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {
    public static final String base = "bdPizzaDelivery.db";
    public static final int version = 1;

    public ConexionSQLiteHelper(@Nullable Context context) {
        super(context, base, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.tabla_Usuario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Utilidades.drop_Usuario);
        onCreate(db);
    }
}
