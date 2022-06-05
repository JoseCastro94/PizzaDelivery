package com.webfactor.jhonnatan.model;

public class Pizza {
    private int codPizza;
    private String imagen;
    private String nombre;
    private double precio;
    private int stock;

    public Pizza(){}

    public Pizza(int codPizza , String imagen, String nombre, double precio, int stock) {
        this.codPizza = codPizza;
        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "imagen='" + imagen + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCodPizza() {
        return codPizza;
    }

    public void setCodPizza(int codPizza) {
        this.codPizza = codPizza;
    }
}
