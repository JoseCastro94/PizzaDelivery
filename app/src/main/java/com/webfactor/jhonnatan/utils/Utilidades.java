package com.webfactor.jhonnatan.utils;

public class Utilidades {
    public static final String tabla_Usuario = "create table Usuario(" +
            "idUsuario Integer primary key autoincrement," +
            "nombre text," +
            "correo text, " +
            "username text," +
            "contrasennia text" +
            ")";
    public static final String drop_Usuario = "drop table if exists Usuario";
}
