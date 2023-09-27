package com.colecciones.laboratoriocolecciones;

import java.util.Comparator;

public class ComparadorLibros {

    public static Comparator<Libro> porTitulo = new Comparator<Libro>() {
        @Override
        public int compare(Libro a, Libro b) {
            return a.getTitulo().compareTo(b.getTitulo());
        }
    };

    public static Comparator<Libro> porAutor = new Comparator<Libro>() {
        @Override
        public int compare(Libro a, Libro b) {
            return a.getAutor().compareTo(b.getAutor());
        }
    };
}
