package com.example.controladorprocesos.model;

public class Proceso {
    private int id;
    private String nombre;

    private ListaEnlazadaDoble<Actividad> actividades;
    private Actividad ultimaActividadInsertada;


///////////////// constructores /////////////////
    public Proceso(){

    }

    public Proceso(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

//////////////////////////// getters y setters ///////////////////////////////


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Actividad getUltimaActividadInsertada() {
        return ultimaActividadInsertada;
    }

    public void setUltimaActividadInsertada(Actividad ultimaActividadInsertada) {
        this.ultimaActividadInsertada = ultimaActividadInsertada;
    }

    //hay que recorrer las actividades para obtener el tiempo de duracion total
    public void getTiempoDuracion(){

    }

///////////////////////////////// metodos ////////////////////////////////

    //busca una tarea en todo el proceso
    public Tarea buscarTareaInicio(Tarea tarea){
        for (Actividad actividad:actividades) {
            buscarTareaActividadActual(actividad,tarea);
        }
        return null;
    }

    //busca una tarea en la actividad actual
    public Tarea buscarTareaActividadActual(Actividad actividad, Tarea tarea){
        int n = actividad.getTareas().obtenerPosicionNodo(tarea);
        if(n > 0){
            return tarea;
        }
        return null;
    }

    //busca una tarea en una actividad, dado el nombre de la actividad
    public Tarea buscarTareaNombreActividad(String nombreActividad, String nombreTarea) {
        for (Actividad actividad : actividades) {
            if (actividad.getNombre().equals(nombreActividad)) {
                return actividad.buscarTareaPorNombre(nombreTarea);
            }
        }
        return null;
    }


    //busca una actividad dado el nombre de la actividad
    public Actividad buscarActividad(String nombre){
        for (Actividad actividad: actividades) {
            if(actividad.getNombre().equalsIgnoreCase(nombre)){
                return actividad;
            }
        }
        return null;
    }


    /*
    hay que intercambiar las tareas de las actividades
     */
    public void intercambiarActividades(Actividad actividad1, Actividad actividad2) {
        actividad1.intercambiarTareas(actividad2);
    }

    /*
    se usaria para intercambiar 2 actividades, sin cambiar sus tareas
     */
    public void intercambiarDatosActividades(Actividad actividad1, Actividad actividad2) {
        actividad1.intercambiarDatos(actividad2);
    }


    public void agregarActividad(Actividad actividad) {
        actividades.agregarFinal(actividad);
        setUltimaActividadInsertada(actividad);
    }

    public void eliminarActividad(Actividad actividad) {
        actividades.eliminar(actividad);
    }

    public int obtenerDuracionTotal() {
        int duracionTotal = 0;
        for (Actividad actividad : actividades) {
            duracionTotal += actividad.calcularDuracionEstimada();
        }
        return duracionTotal;
    }


}
