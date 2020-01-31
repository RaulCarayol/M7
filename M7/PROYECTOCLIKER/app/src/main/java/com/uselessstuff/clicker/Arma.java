package com.uselessstuff.clicker;

import android.content.res.Resources;

public class Arma {
    private String nombre;
    private String descripcion;
    private int danyo,coste;
    private int imagen;

    public Arma(String nombre,int danyo,int coste,String descripcion,int res){
        this.nombre = nombre;
        this.danyo = danyo;
        this.coste = coste;
        this.descripcion= descripcion;
        this.imagen = res;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion(){ return descripcion;}

    public int getDanyo(){ return danyo;}

    public int getImagen(){return imagen;}

    public int getCoste(){return coste;}
}
