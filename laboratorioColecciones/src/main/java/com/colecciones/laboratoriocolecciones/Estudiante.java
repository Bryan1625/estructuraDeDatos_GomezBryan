package com.colecciones.laboratoriocolecciones;

import java.util.ArrayList;

public class Estudiante extends Persona{
    private ArrayList<Libro> libros;
    private int cantLibros;

    public Estudiante(String nombre, int id) {
        super(nombre, id);
        libros = new ArrayList<>();
        cantLibros = 0;
    }

    public void recibirPrestamoLibro(Libro libro){
        libros.add(libro);
        cantLibros = libros.size();
    }

    public void devolverLibro(Libro libro){
        libro.setDisponible(true);
        libros.remove(libro);
        cantLibros = libros.size();
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
        cantLibros = libros.size();
    }

    public int getCantLibros() {
        return libros.size();
    }
}
