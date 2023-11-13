package com.example.controladorprocesos.model;

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
        // Lógica para agregar una tarea a la actividad
    }

    public void eliminarTarea(Tarea tarea) {
        // Lógica para eliminar una tarea de la actividad
    }

    public ListaEnlazadaDoble<Tarea> obtenerTareas() {
        // Lógica para obtener la lista de tareas de la actividad
        return null;
    }

    public int calcularDuracionEstimada() {
        // Lógica para calcular la duración estimada de la actividad
        return 0;
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
    }

    public void intercambiarTareas(Actividad actividad2) {
        ListaEnlazadaDoble<Tarea> aux = this.tareas;
        setTareas(actividad2.getTareas());
        actividad2.setTareas(aux);
    }
}
