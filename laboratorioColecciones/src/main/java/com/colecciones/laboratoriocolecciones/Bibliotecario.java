package com.colecciones.laboratoriocolecciones;

public class Bibliotecario extends Persona implements Comparable<Bibliotecario>{

    public Bibliotecario(String nombre, int id) {
        super(nombre, id);
    }

    @Override
    public int compareTo(Bibliotecario o) {
        if(getId()<o.getId()){
            return 1;
        }else{
            return -1;
        }
    }

}
