package com.colecciones.laboratoriocolecciones;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Biblioteca {
    private final String nombre = "Biblioteca";
    private HashMap<Integer, Prestamo> prestamos;
    private TreeSet<Bibliotecario> bibliotecarios;
    private HashSet<Estudiante> estudiantes;
    private TreeSet<Libro> libros;
    private int ultimoIdPrestamo;
    private int ultimoIdDetallePrestamo;

    public HashMap<Integer, Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(HashMap<Integer, Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public TreeSet<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    public void setBibliotecarios(TreeSet<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }

    public HashSet<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(HashSet<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public TreeSet<Libro> getLibros() {
        return libros;
    }

    public void setLibros(TreeSet<Libro> libros) {
        this.libros = libros;
    }

    public int getUltimoIdPrestamo() {
        return ultimoIdPrestamo;
    }

    public void setUltimoIdPrestamo(int ultimoIdPrestamo) {
        this.ultimoIdPrestamo = ultimoIdPrestamo;
    }

    public int getUltimoIdDetallePrestamo() {
        return ultimoIdDetallePrestamo;
    }

    public void setUltimoIdDetallePrestamo(int ultimoIdDetallePrestamo) {
        this.ultimoIdDetallePrestamo = ultimoIdDetallePrestamo;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.put(prestamo.getId(), prestamo);
    }
    public void eliminarPrestamo(Prestamo prestamo){
        prestamos.remove(prestamo);
    }

    public boolean registrarPrestamo(Estudiante estudiante, Libro libro) {
        if(libro.isDisponible()){
            estudiante.recibirPrestamoLibro(libro);
            libro.setDisponible(false);
            DetallePrestamo detalle = new DetallePrestamo(obtenerIdDetallePrestamo(),obtenerFechaYHora());
            Prestamo prestamo = new Prestamo(obtenerIdPrestamo());
            prestamo.agregarDetalle(detalle);
            agregarPrestamo(prestamo);
            return true;
        }
        return false;
    }

    public String obtenerFechaYHora(){
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "Fecha y Hora: " + ahora.format(formatter);
    }

    public void agregarDetallePrestamo(Prestamo prestamo, DetallePrestamo detalle){
        prestamo.agregarDetalle(detalle);
    }

    public DetallePrestamo obtenerDetallePrestamo(int id) {
        for (int i = 0; i < prestamos.size(); i++) {
            if(prestamos.get(i).obtenerDetallePrestamo(id) != null){
                return prestamos.get(i).obtenerDetallePrestamo(id);
            }
        }
        return null;
    }

    public boolean recibirDevolucion(Libro libro, Estudiante estudiante){
        if(estudiante.getLibros().contains(libro)){
            estudiante.devolverLibro(libro);
            return true;
        }
        return false;
    }

    public int obtenerIdPrestamo(){
        return ++ultimoIdPrestamo;
    }
    public int obtenerIdDetallePrestamo(){
        return ++ultimoIdDetallePrestamo;
    }


    public Prestamo obtenerPrestamo(int id) {
        return prestamos.get(id);
    }

    public void agregarBibliotecario(Bibliotecario b){
        bibliotecarios.add(b);
    }

    public Bibliotecario obtenerBibliotecario(int id) {
        Iterator<Bibliotecario> iterator = bibliotecarios.iterator();
        while (iterator.hasNext()) {
            Bibliotecario b = iterator.next();
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public void eliminarBibliotecario(Bibliotecario b){
        bibliotecarios.remove(b);
    }

    public void agregarEstudiante(Estudiante e){
        estudiantes.add(e);
    }

    public Estudiante obtenerEstudiante(int id) {
        Iterator<Estudiante> iterator = estudiantes.iterator();
        while (iterator.hasNext()) {
            Estudiante e = iterator.next();
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
    public void eliminarEstudiante(Estudiante e){
        estudiantes.remove(e);
    }

    public Libro obtenerLibro(String titulo) {
        Iterator<Libro> iterator = libros.iterator();
        while (iterator.hasNext()) {
            Libro libro = iterator.next();
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public void agregarLibro(Libro libro){
        libros.add(libro);
    }

    public void eliminarLibro(Libro l){
        libros.remove(l);
    }

    public TreeSet<Libro> obtenerLibrosPorTitulo(){
        TreeSet<Libro> libros = new TreeSet<>(ComparadorLibros.porTitulo);
        libros.addAll(this.libros);
        return libros;
    }

    public void actualizarBibliotecario(int id, String nuevoNombre) {
        Bibliotecario bibliotecario = obtenerBibliotecario(id);
        if (bibliotecario != null) {
            bibliotecario.setNombre(nuevoNombre);
        }
    }

    public void actualizarEstudiante(int id, String nuevoNombre) {
        Estudiante estudiante = obtenerEstudiante(id);
        if (estudiante != null) {
            estudiante.setNombre(nuevoNombre);
        }
    }

    public void actualizarLibro(String titulo, String nuevoAutor) {
        Libro libro = obtenerLibro(titulo);
        if (libro != null) {
            libro.setAutor(nuevoAutor);
        }
    }

    public Biblioteca() {
        prestamos = new HashMap<>();
        bibliotecarios = new TreeSet<>();
        estudiantes = new HashSet<>();
        libros = new TreeSet<>(ComparadorLibros.porAutor);
        ultimoIdPrestamo = 0;
        ultimoIdDetallePrestamo = 0;
    }

    public String getNombre() {
        return nombre;
    }
}
