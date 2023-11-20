package com.example.controladorprocesos.controllers;

import com.example.controladorprocesos.model.*;

import java.util.List;

public class UsuarioController {
    ModelFactoryController modelFactoryController;
    public UsuarioController(){
        modelFactoryController = ModelFactoryController.getInstance();
    }
    public List<Proceso> buscarProcesoNombre(String nombreProceso) {
        return modelFactoryController.buscarProcesosNombre(nombreProceso);
    }

    public Proceso buscarProcesoId(int idProceso) {
        return modelFactoryController.buscarProcesoId(idProceso);
    }
}
