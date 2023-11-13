package com.example.controladorprocesos.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Actividad {
    private String nombre;
    private String descripcion;
    private boolean obligatoria;

    private ListaEnlazadaDoble<Tarea> tareas;

    public Actividad() {
    }

    public Actividad(String nombre, String descripcion, boolean obligatoria, ListaEnlazadaDoble<Tarea> tareas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.obligatoria = obligatoria;
        this.tareas = tareas;
    }

    public ListaEnlazadaDoble<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(ListaEnlazadaDoble<Tarea> tareas) {
        this.tareas = tareas;
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

    public boolean isObligatoria() {
        return obligatoria;
    }

    public void setObligatoria(boolean obligatoria) {
        this.obligatoria = obligatoria;
    }

    public void agregarTarea(Tarea tarea) {
        tareas.agregarFinal(tarea);
    }

    public void agregarTarea(Tarea tarea, int i){
        tareas.agregar(tarea,i);
    }

    public void eliminarTarea(Tarea tarea) {
        tareas.eliminar(tarea);
    }

    public ListaEnlazadaDoble<Tarea> obtenerTareas() {
        return tareas;
    }

    public double calcularDuracionEstimada() {
        double aux = 0;
        for (Tarea tarea: tareas) {
            aux += tarea.getTiempoMinutos();
        }
        return aux;
    }


    public Tarea buscarTareaPorNombre(String nombreTarea) {
        for (Tarea tarea: tareas) {
            if(tarea.getNombre().equalsIgnoreCase(nombreTarea)){
                return tarea;
            }
        }
        return null;
    }

    public void intercambiarDatos(Actividad actividad2) {
        Actividad temp = new Actividad();

        temp.setNombre(getNombre());
        temp.setDescripcion(getDescripcion());
        temp.setObligatoria(isObligatoria());

        setNombre(actividad2.getNombre());
        setDescripcion(actividad2.getDescripcion());
        setObligatoria(actividad2.isObligatoria());

        actividad2.setNombre(temp.getNombre());
        actividad2.setDescripcion(temp.getDescripcion());
        actividad2.setObligatoria(temp.isObligatoria());
    }


    public void intercambiarTareas(Actividad actividad2) {
        ListaEnlazadaDoble<Tarea> copiaTareas1 = new ListaEnlazadaDoble<>(this.tareas);
        ListaEnlazadaDoble<Tarea> copiaTareas2 = new ListaEnlazadaDoble<>(actividad2.getTareas());

        setTareas(copiaTareas2);
        actividad2.setTareas(copiaTareas1);
    }


}
