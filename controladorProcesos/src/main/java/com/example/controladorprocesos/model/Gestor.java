package com.example.controladorprocesos.model;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Clase que gestiona procesos, usuarios y notificaciones en la aplicación.
 */
public class Gestor {
    // Atributos
    private ListaEnlazadaDoble<Proceso> procesos;
    private ListaEnlazadaDoble<Usuario> usuarios;
    private ListaEnlazadaDoble<Notificacion> notificaciones;
    private Usuario usuario;

    // Constructor
    /**
     * Constructor que inicializa las listas de procesos, usuarios y notificaciones.
     */
    public Gestor() {
        this.procesos = new ListaEnlazadaDoble<>();
        this.usuarios = new ListaEnlazadaDoble<>();
        this.notificaciones = new ListaEnlazadaDoble<>();
    }

    public ListaEnlazadaDoble<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(ListaEnlazadaDoble<Proceso> procesos) {
        this.procesos = procesos;
    }

    public ListaEnlazadaDoble<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ListaEnlazadaDoble<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ListaEnlazadaDoble<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(ListaEnlazadaDoble<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
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


    public void exportarExcelProceso(Proceso proceso, String nombreArchivo) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Proceso");

            // Crear la primera fila con los encabezados
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Nombre");
            headerRow.createCell(2).setCellValue("Tiempo (minutos)");

            // Crear una fila con los datos del proceso
            Row dataRow = sheet.createRow(1);
            dataRow.createCell(0).setCellValue(proceso.getId());
            dataRow.createCell(1).setCellValue(proceso.getNombre());
            dataRow.createCell(2).setCellValue(proceso.getTiempoMinutos());

            // Escribir el archivo Excel
            try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exportarExcelListaProcesos(String nombreArchivo) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Procesos");

            // Crear la primera fila con los encabezados
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Nombre");
            headerRow.createCell(2).setCellValue("Tiempo (minutos)");

            // Crear filas con los datos de cada proceso
            int rowNum = 1;
            for (Proceso proceso : procesos) {
                Row dataRow = sheet.createRow(rowNum++);
                dataRow.createCell(0).setCellValue(proceso.getId());
                dataRow.createCell(1).setCellValue(proceso.getNombre());
                dataRow.createCell(2).setCellValue(proceso.getTiempoMinutos());
            }

            // Escribir el archivo Excel
            try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void login(String usuario, String contrasenia){
        for (Usuario u:usuarios) {
            if (usuario == u.getNombreUsuario() && contrasenia == u.getContrasenia()) {
                this.usuario = u;
                realizarProcesos();
            }
        }
    }

    public void realizarProcesos(){
        for (Proceso p: procesos) {
            p.realizarProceso(usuario.getNombreUsuario());
        }
    }
}
