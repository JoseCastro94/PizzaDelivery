package com.webfactor.jhonnatan.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.webfactor.jhonnatan.model.Pizza;
import com.webfactor.jhonnatan.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class PizzaDAO {
    private ConexionSQLiteHelper  conn;
    private SQLiteDatabase db;

    public PizzaDAO(Context contexto){
        conn=new ConexionSQLiteHelper(contexto);
        db=conn.getWritableDatabase();
    }
    public long Insertar(Pizza obj){
        ContentValues values=new ContentValues();

        values.put("nombre",obj.getNombre());
        values.put("precio",obj.getPrecio());
        values.put("stock",obj.getStock());
        values.put("imagen",obj.getImagen());
        long res= db.insert("Pizza",null,values);
        return  res;
    }

    public long Modificar(Pizza obj){
        ContentValues values=new ContentValues();

        values.put("nombre",obj.getNombre());
        values.put("precio",obj.getPrecio());
        values.put("stock",obj.getStock());
        long res= db.update("Pizza",values,"idPizza="+obj.getCodPizza(),null);
        return  res;
    }


    public ArrayList<Pizza> listado(){
        ArrayList<Pizza> lista=new ArrayList<>();
        Cursor cursor=null;
        cursor=db.rawQuery("select idPizza,nombre,precio,stock,imagen " +
                "from Pizza",null);

        while(cursor.moveToNext()){
            Pizza p=new Pizza();
            p.setCodPizza(cursor.getInt(0));
            p.setNombre(cursor.getString(1));
            p.setPrecio(cursor.getDouble(2));
            p.setStock(cursor.getInt(3));
            p.setImagen(cursor.getString(4));
            lista.add(p);
        }
        return lista;
    }

    public int Eliminar(int id){
        int res = 0;
        try{
            res = (int) db.delete("Pizza","idPizza="+id,null);
        }catch (Exception e){
        }
        return res;
    }

    public Pizza Consulta(int id){
        Pizza obj=null;
        Cursor cursor=null;
        cursor=db.rawQuery("select idPizza,nombre,precio,stock,imagen " +
                "from Pizza where idPizza="+id,null);

        if(cursor.moveToNext()){
            obj =new Pizza();
            obj.setCodPizza(cursor.getInt(0));
            obj.setNombre(cursor.getString(1));
            obj.setPrecio(cursor.getDouble(2));
            obj.setStock(cursor.getInt(3));
            obj.setImagen(cursor.getString(4));
        }
        return obj;
    }

}
