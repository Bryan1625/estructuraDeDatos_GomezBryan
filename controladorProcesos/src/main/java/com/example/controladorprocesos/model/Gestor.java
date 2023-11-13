package com.example.controladorprocesos.model;

import java.util.ArrayList;

/**
 * Clase que gestiona procesos, usuarios y notificaciones en la aplicación.
 */
public class Gestor {
    // Atributos
    private ArrayList<Proceso> procesos;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Notificacion> notificaciones;

    // Constructor
    /**
     * Constructor que inicializa las listas de procesos, usuarios y notificaciones.
     */
    public Gestor() {
        this.procesos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
    }

    // Métodos para gestionar procesos
    /**
     * Agrega un proceso a la lista de procesos.
     *
     * @param proceso Proceso a agregar.
     */
    public void agregarProceso(Proceso proceso) {
        procesos.add(proceso);
    }

    /**
     * Elimina un proceso de la lista de procesos.
     *
     * @param proceso Proceso a eliminar.
     */
    public void eliminarProceso(Proceso proceso) {
        procesos.remove(proceso);
    }

    /**
     * Busca un proceso por su nombre en la lista de procesos.
     *
     * @param nombre Nombre del proceso a buscar.
     * @return Proceso encontrado o null si no existe.
     */
    public Proceso buscarProcesoPorNombre(String nombre) {
        for (Proceso proceso : procesos) {
            if (proceso.getNombre().equalsIgnoreCase(nombre)) {
                return proceso;
            }
        }
        return null;
    }

    // Métodos para gestionar usuarios
    /**
     * Agrega un usuario a la lista de usuarios.
     *
     * @param usuario Usuario a agregar.
     */
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    /**
     * Elimina un usuario de la lista de usuarios.
     *
     * @param usuario Usuario a eliminar.
     */
    public void eliminarUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    /**
     * Busca un usuario por su nombre en la lista de usuarios.
     *
     * @param nombre Nombre del usuario a buscar.
     * @return Usuario encontrado o null si no existe.
     */
    public Usuario buscarUsuarioPorNombre(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equalsIgnoreCase(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    // Métodos para gestionar notificaciones
    /**
     * Agrega una notificación a la lista de notificaciones.
     *
     * @param notificacion Notificación a agregar.
     */
    public void agregarNotificacion(Notificacion notificacion) {
        notificaciones.add(notificacion);
    }

    /**
     * Elimina una notificación de la lista de notificaciones.
     *
     * @param notificacion Notificación a eliminar.
     */
    public void eliminarNotificacion(Notificacion notificacion) {
        notificaciones.remove(notificacion);
    }

    /**
     * Busca una notificación por su ID en la lista de notificaciones.
     *
     * @param id ID de la notificación a buscar.
     * @return Notificación encontrada o null si no existe.
     */
    public Notificacion buscarNotificacionPorId(int id) {
        for (Notificacion notificacion : notificaciones) {
            if (notificacion.getId() == id) {
                return notificacion;
            }
        }
        return null;
    }

    // Métodos adicionales
    /**
     * Asigna una actividad a un proceso.
     *
     * @param proceso   Proceso al que se asignará la actividad.
     * @param actividad Actividad a asignar.
     */
    public void asignarActividadAProceso(Proceso proceso, Actividad actividad) {
        proceso.agregarActividad(actividad);
    }

    /**
     * Elimina una actividad de un proceso.
     *
     * @param proceso   Proceso del que se eliminará la actividad.
     * @param actividad Actividad a eliminar.
     */
    public void eliminarActividadDeProceso(Proceso proceso, Actividad actividad) {
        proceso.eliminarActividad(actividad);
    }

    /**
     * Intercambia dos actividades en un proceso.
     *
     * @param proceso     Proceso en el que se realizará el intercambio.
     * @param actividad1  Primera actividad a intercambiar.
     * @param actividad2  Segunda actividad a intercambiar.
     */
    public void intercambiarActividadesEnProceso(Proceso proceso, Actividad actividad1, Actividad actividad2) {
        proceso.intercambiarActividades(actividad1, actividad2);
    }

    /**
     * Busca una tarea en un proceso por su nombre.
     *
     * @param proceso     Proceso en el que se buscará la tarea.
     * @param nombreTarea Nombre de la tarea a buscar.
     * @return Tarea encontrada o null si no existe.
     */
    public Tarea buscarTareaEnProceso(Proceso proceso, String nombreTarea) {
        return proceso.buscarTareaInicio(nombreTarea);
    }
}
