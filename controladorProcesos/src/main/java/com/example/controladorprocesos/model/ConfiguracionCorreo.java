package com.example.controladorprocesos.model;

public class ConfiguracionCorreo {
    private String usuario;
    private String contrasenia;

    public ConfiguracionCorreo(String usuario, String contrasenia) {

        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }
}


