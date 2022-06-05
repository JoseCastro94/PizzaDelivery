package com.webfactor.jhonnatan.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.webfactor.jhonnatan.model.Usuario;

public class UsuarioDAO {
    private ConexionSQLiteHelper  conn;
    private SQLiteDatabase db;

    public UsuarioDAO(Context contexto){
        conn=new ConexionSQLiteHelper(contexto);
        db=conn.getWritableDatabase();
    }

    public long Insertar(Usuario obj){
        ContentValues values=new ContentValues();

        values.put("nombre",obj.getNombre());
        values.put("correo",obj.getCorreo());
        values.put("username",obj.getUsername());
        values.put("contrasennia",obj.getContrasennia());
        long res= db.insert("Usuario",null,values);
        return  res;
    }

    public Usuario Consultar(String username , String pass){
        Usuario obj=null;
        Cursor cursor=null;
        String parametros[]={username , pass};
        try{
            cursor=db.rawQuery("select idUsuario,nombre,correo,username " +
                    "from Usuario where username=? and contrasennia=?",parametros);

            if(cursor.moveToNext()){
                obj=new Usuario();
                obj.setIdUsuario(cursor.getInt(0));
                obj.setNombre(cursor.getString(1));
                obj.setCorreo(cursor.getString(2));
                obj.setUsername(cursor.getString(3));
            }
            cursor.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return obj;
    }

    public int ExisteUsuario(String username){
        int res = 0;
        Cursor cursor=null;
        String parametros[]={username};
        try{
            cursor=db.rawQuery("select count(1) " +
                    "from Usuario where username=? ",parametros);
            if(cursor.moveToNext()){
                res = cursor.getInt(0);
            }
            cursor.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return res;
    }
}
