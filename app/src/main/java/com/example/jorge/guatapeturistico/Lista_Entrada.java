package com.example.jorge.guatapeturistico;

/**
 * Created by jorge on 13/03/17.
 */

public class Lista_Entrada {

    private int idImagen,precio1,precio2;
    private String nombre,descripcion;

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public int getPrecio1() {
        return precio1;
    }

    public int getPrecio2() {
        return precio2;
    }

    public void setPrecio1(int precio1 ) {
        this.precio1 = precio1;
    }

    public void setPrecio2(int precio2 ) {
        this.precio2 = precio2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Lista_Entrada(int idImagen, int precio1, int precio2, String nombre, String descripcion) {
        this.idImagen = idImagen;
        this.precio1 = precio1;
        this.precio2 = precio2;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
