package com.example.controladorprocesos.model;

import java.util.ArrayList;

import java.util.ArrayList;

public class Gestor {
    private ArrayList<Proceso> procesos;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Notificacion> notificaciones;

    public Gestor() {
        this.procesos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
    }

    // Métodos para gestionar procesos
    public void agregarProceso(Proceso proceso) {
        procesos.add(proceso);
    }

    public void eliminarProceso(Proceso proceso) {
        procesos.remove(proceso);
    }

    public Proceso buscarProcesoPorNombre(String nombre) {
        for (Proceso proceso : procesos) {
            if (proceso.getNombre().equalsIgnoreCase(nombre)) {
                return proceso;
            }
        }
        return null;
    }

    // Métodos para gestionar usuarios
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void eliminarUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public Usuario buscarUsuarioPorNombre(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equalsIgnoreCase(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    // Métodos para gestionar notificaciones
    public void agregarNotificacion(Notificacion notificacion) {
        notificaciones.add(notificacion);
    }

    public void eliminarNotificacion(Notificacion notificacion) {
        notificaciones.remove(notificacion);
    }

    public Notificacion buscarNotificacionPorId(int id) {
        for (Notificacion notificacion : notificaciones) {
            if (notificacion.getId() == id) {
                return notificacion;
            }
        }
        return null;
    }

    public void asignarActividadAProceso(Proceso proceso, Actividad actividad) {
        proceso.agregarActividad(actividad);
    }

    public void eliminarActividadDeProceso(Proceso proceso, Actividad actividad) {
        proceso.eliminarActividad(actividad);
    }

    public void intercambiarActividadesEnProceso(Proceso proceso, Actividad actividad1, Actividad actividad2) {
        proceso.intercambiarActividades(actividad1, actividad2);
    }

    public Tarea buscarTareaEnProceso(Proceso proceso, String nombreTarea) {
        return proceso.buscarTareaInicio(nombreTarea);
    }


}
