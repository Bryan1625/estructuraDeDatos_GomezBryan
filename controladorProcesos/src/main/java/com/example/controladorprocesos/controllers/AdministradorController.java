package com.example.controladorprocesos.controllers;

import com.example.controladorprocesos.model.*;
import javafx.event.ActionEvent;

import java.util.List;

public class AdministradorController {
    ModelFactoryController modelFactoryController;
    public AdministradorController(){
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public List<Proceso> buscarProcesoNombre(String nombreProceso) {
        return modelFactoryController.buscarProcesosNombre(nombreProceso);
    }

    public void buscarProcesoId() {
    }

    public void actualizarTablaProcesos() {
    }

    public void buscarActividadNombre() {
    }

    public void actualizarTablaActividades() {
    }

    public void buscarTareaNombre() {
    }

    public void actualizarTablaTareas() {
    }

    public void exportarProcesosExcel() {
    }

    public void adminImportarProcesosCSV() {
    }

    public void actualizarProceso() {
    }

    public void actualizarActividad() {
    }

    public void actualizarTarea() {
    }

    public void adminBuscarUsuario() {
    }

    public void actualizarUsuario() {
    }

    public void eliminarUsuario() {
    }

    public void agregarUsuario() {
    }

    public void exportarUsuariosExcel() {
    }

    public void adminImportarUsuariosCSV() {
    }

    public void eliminarTarea() {
    }

    public void eliminarActividad() {
    }

    public void eliminarProceso() {
    }

    public void agregarProceso() {
    }

    public void agregarActividad() {
    }

    public void agregarTarea() {
    }
}
