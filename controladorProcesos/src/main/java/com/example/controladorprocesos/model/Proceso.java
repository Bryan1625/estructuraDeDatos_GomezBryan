package com.example.controladorprocesos.model;

/**
 * Representa un proceso que contiene actividades.
 */
public class Proceso {
    private int id;
    private String nombre;
    private ListaEnlazadaDoble<Actividad> actividades;
    private Actividad ultimaActividadInsertada;

    /**
     * Constructor por defecto de la clase Proceso.
     */
    public Proceso() {
        this.actividades = new ListaEnlazadaDoble<>();
    }

    /**
     * Constructor de la clase Proceso con parámetros.
     *
     * @param id     Identificador del proceso.
     * @param nombre Nombre del proceso.
     */
    public Proceso(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.actividades = new ListaEnlazadaDoble<>();
    }

    public Proceso(String nombre) {
        this.nombre = nombre;
        this.actividades = new ListaEnlazadaDoble<>();
    }

    public ListaEnlazadaDoble<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(ListaEnlazadaDoble<Actividad> actividades) {
        this.actividades = actividades;
    }

    /**
     * Obtiene el identificador del proceso.
     *
     * @return Identificador del proceso.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del proceso.
     *
     * @param id Identificador del proceso.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del proceso.
     *
     * @return Nombre del proceso.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del proceso.
     *
     * @param nombre Nombre del proceso.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la última actividad insertada en el proceso.
     *
     * @return Última actividad insertada.
     */
    public Actividad getUltimaActividadInsertada() {
        return ultimaActividadInsertada;
    }

    /**
     * Establece la última actividad insertada en el proceso.
     *
     * @param ultimaActividadInsertada Última actividad insertada.
     */
    public void setUltimaActividadInsertada(Actividad ultimaActividadInsertada) {
        this.ultimaActividadInsertada = ultimaActividadInsertada;
    }

    /**
     * Obtiene la duración total estimada del proceso sumando las duraciones de todas las actividades.
     *
     * @return Duración total estimada del proceso.
     */
    public double obtenerDuracionTotal() {
        double duracionTotal = 0;
        if(actividades != null && actividades.size() == 0){
            return 0;
        }
        for (Actividad actividad : actividades) {
            duracionTotal += actividad.calcularDuracionEstimada();
        }
        return duracionTotal;
    }

    /**
     * Busca una tarea en todas las actividades del proceso.
     *
     * @param nombreTarea Nombre de la tarea a buscar.
     * @return Tarea encontrada o null si no se encuentra.
     */
    public Tarea buscarTareaInicio(String nombreTarea) {
        for (Actividad actividad : actividades) {
            Tarea tarea = buscarTareaActividadActual(actividad, nombreTarea);
            if (tarea != null) {
                return tarea;
            }
        }
        return null;
    }

    /**
     * Busca una tarea en la actividad actual.
     *
     * @param actividad   Actividad en la que se busca la tarea.
     * @param nombreTarea Nombre de la tarea a buscar.
     * @return Tarea encontrada o null si no se encuentra.
     */
    public Tarea buscarTareaActividadActual(Actividad actividad, String nombreTarea) {
        for (Tarea tarea : actividad.getTareas()) {
            if (tarea.getNombre().equalsIgnoreCase(nombreTarea)) {
                return tarea;
            }
        }
        return null;
    }

    /**
     * Busca una tarea en una actividad dado el nombre de la actividad.
     *
     * @param nombreActividad Nombre de la actividad en la que se busca la tarea.
     * @param nombreTarea     Nombre de la tarea a buscar.
     * @return Tarea encontrada o null si no se encuentra.
     */
    public Tarea buscarTareaNombreActividad(String nombreActividad, String nombreTarea) {
        for (Actividad actividad : actividades) {
            if (actividad.getNombre().equals(nombreActividad)) {
                return actividad.buscarTareaPorNombre(nombreTarea);
            }
        }
        return null;
    }

    /**
     * Busca una actividad dado el nombre de la actividad.
     *
     * @param nombre Nombre de la actividad a buscar.
     * @return Actividad encontrada o null si no se encuentra.
     */
    public Actividad buscarActividad(String nombre) {
        for (Actividad actividad : actividades) {
            if (actividad.getNombre().equalsIgnoreCase(nombre)) {
                return actividad;
            }
        }
        return null;
    }

    /**
     * Intercambia las tareas de dos actividades en el proceso.
     *
     * @param actividad1 Primera actividad.
     * @param actividad2 Segunda actividad.
     */
    public void intercambiarActividades(Actividad actividad1, Actividad actividad2) {
        actividad1.intercambiarTareas(actividad2);
    }

    /**
     * Intercambia datos de dos actividades sin cambiar sus tareas.
     *
     * @param actividad1 Primera actividad.
     * @param actividad2 Segunda actividad.
     */
    public void intercambiarDatosActividades(Actividad actividad1, Actividad actividad2) {
        actividad1.intercambiarDatos(actividad2);
    }

    /**
     * Agrega una actividad al proceso.
     *
     * @param actividad Actividad a agregar.
     */
    public void agregarActividad(Actividad actividad) {
        actividades.agregarFinal(actividad);
        setUltimaActividadInsertada(actividad);
    }

    /**
     * Elimina una actividad del proceso.
     *
     * @param actividad Actividad a eliminar.
     */
    public void eliminarActividad(Actividad actividad) {
        actividades.eliminar(actividad);
    }
}
