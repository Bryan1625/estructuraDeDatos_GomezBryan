package model;

import java.util.ArrayList;

public class Estudiante extends Persona{
    private ArrayList<Libro> libros;

    public Estudiante(String nombre, int id) {
        super(nombre, id);
        libros = new ArrayList<>();
    }

    public void recibirPrestamoLibro(Libro libro){
        libros.add(libro);
    }

    public void devolverLibro(Libro libro){
        libro.setDisponible(true);
        libros.remove(libro);
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }
}
