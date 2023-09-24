package controllers;

import model.*;

import java.util.ArrayList;
import java.util.TreeSet;

public class BibliotecaController {
    private Biblioteca biblioteca;

    public BibliotecaController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void inicializarDatos() {

        Estudiante estudiante1 = new Estudiante("Carlos", 1);
        Estudiante estudiante2 = new Estudiante("Juan", 2);
        Estudiante estudiante3 = new Estudiante("Esteban", 3);
        Estudiante estudiante4 = new Estudiante("Laura", 4);
        Estudiante estudiante5 = new Estudiante("Ana", 5);
        Estudiante estudiante6 = new Estudiante("Sofia", 6);
        Estudiante estudiante7 = new Estudiante("Nicolas", 7);


        Bibliotecario bibliotecario1 = new Bibliotecario("Bryan", 101);
        Bibliotecario bibliotecario2 = new Bibliotecario("Camila", 102);


        Libro libro1 = new Libro("Cronica de una Muerte Anunciada", "Gabriel Garcia Marquez");
        Libro libro2 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes");
        Libro libro3 = new Libro("1984", "George Orwell");
        Libro libro4 = new Libro("Matar a un ruiseñor", "Harper Lee");
        Libro libro5 = new Libro("El Gran Gatsby", "F. Scott Fitzgerald");
        Libro libro6 = new Libro("Crimen y castigo", "Fiodor Dostoievski");



        biblioteca.agregarEstudiante(estudiante1);
        biblioteca.agregarEstudiante(estudiante2);
        biblioteca.agregarEstudiante(estudiante3);
        biblioteca.agregarEstudiante(estudiante4);
        biblioteca.agregarEstudiante(estudiante5);
        biblioteca.agregarEstudiante(estudiante6);
        biblioteca.agregarEstudiante(estudiante7);

        biblioteca.agregarBibliotecario(bibliotecario1);
        biblioteca.agregarBibliotecario(bibliotecario2);


        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);
        biblioteca.agregarLibro(libro5);
        biblioteca.agregarLibro(libro6);

    }

    // Métodos para registrar un préstamo y una devolución
    public boolean registrarPrestamo(Estudiante estudiante, Libro libro) {
        return biblioteca.registrarPrestamo(estudiante, libro);
    }

    public boolean recibirDevolucion(Libro libro, Estudiante estudiante) {
        return biblioteca.recibirDevolucion(libro, estudiante);
    }

    // Métodos para eliminar elementos de las colecciones
    public boolean eliminarPrestamo(Prestamo prestamo) {
        if (prestamo != null) {
            biblioteca.eliminarPrestamo(prestamo);
            return true;
        }
        return false;
    }

    public boolean eliminarBibliotecario(Bibliotecario bibliotecario) {
        if (bibliotecario != null) {
            biblioteca.eliminarBibliotecario(bibliotecario);
            return true;
        }
        return false;
    }

    public boolean eliminarEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            biblioteca.eliminarEstudiante(estudiante);
            return true;
        }
        return false;
    }

    public boolean eliminarLibro(Libro libro) {
        if (libro != null) {
            biblioteca.eliminarLibro(libro);
            return true;
        }
        return false;
    }

    // Métodos para consultar información
    public ArrayList<DetallePrestamo> obtenerDetallesPrestamo(int idPrestamo) {
        Prestamo prestamo = biblioteca.obtenerPrestamo(idPrestamo);
        if (prestamo != null) {
            return prestamo.getDetalles();
        }
        return null;
    }

    public TreeSet<Libro> obtenerLibrosPorTitulo() {
        return biblioteca.obtenerLibrosPorTitulo();
    }

    public Bibliotecario obtenerBibliotecario(int id) {
        return biblioteca.obtenerBibliotecario(id);
    }

    public Estudiante obtenerEstudiante(int id) {
        return biblioteca.obtenerEstudiante(id);
    }
}
