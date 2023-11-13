package com.example.controladorprocesos.model;

public class Usuario {
    private String nombreUsuario;
    private String contrasenia;
    private TipoUsuario tipoUsuario;

    public Usuario(String nombreUsuario, String contrasenia, TipoUsuario tipoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
// solo administradores crean procesos