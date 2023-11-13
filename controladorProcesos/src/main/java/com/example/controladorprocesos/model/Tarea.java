package com.example.controladorprocesos.model;

public class Tarea {
    private String nombre;
    private String descripcion;
    private boolean obligatoria;
    private int tiempoMinutos;

    public Tarea(String nombre, String descripcion, boolean obligatoria, int tiempoMinutos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.obligatoria = obligatoria;
        this.tiempoMinutos = tiempoMinutos;
    }

    public Tarea() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isObligatoria() {
        return obligatoria;
    }

    public void setObligatoria(boolean obligatoria) {
        this.obligatoria = obligatoria;
    }

    public int getTiempoMinutos() {
        return tiempoMinutos;
    }

    public void setTiempoMinutos(int tiempoMinutos) {
        this.tiempoMinutos = tiempoMinutos;
    }

    public void realizarTarea(){
        try {
            Thread.sleep(tiempoMinutos * 60000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
