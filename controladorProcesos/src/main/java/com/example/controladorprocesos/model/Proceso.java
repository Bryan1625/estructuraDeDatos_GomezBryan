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

    public ListaEnlazadaDoble<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(ListaEnlazadaDoble<Proceso> procesos) {
        this.procesos = procesos;
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
    public Tarea buscarTareaInicio(){

    }

    //busca una tarea en la actividad actual
    public Tarea buscarTareaActividadActual(Actividad actividad){

    }

    //busca una tarea en una actividad, dado el nombre de la actividad
    public Tarea buscarTareaNombreActividad(String nombre){

    }

    //busca una actividad dado el nombre de la actividad
    public Actividad buscarActividad(String nombbre){

    }


    /*
    hay que intercambiar las tareas de las actividades
     */
    public void intercambiarActividades(Actividad actividad1, Actividad actividad2) {

    }

    /*
    se usaria para intercambiar 2 actividades, sin cambiar sus tareas
     */
    public void intercambiarDatosActividades(Actividad actividad1, Actividad actividad2){

    }
}
